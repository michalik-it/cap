package com.stanusch.omnibot.rest.repository.sequencer;

import com.stanusch.omnibot.rest.repository.model.BasicEntity;
import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Aspect
public class SequencerAspect {

    private final SequencerTool sequencerTool;

    @Autowired
    public SequencerAspect(SequencerTool sequencerTool) {
        this.sequencerTool = sequencerTool;
    }

    @Pointcut("execution(* com.stanusch.omnibot.rest.repository.*Repository.save*(Object))")
    public void repositoryInterfaceSaveMethods() { }

    @Around("repositoryInterfaceSaveMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Stream.of(args).forEach(
                arg -> {
                    if (arg instanceof BasicEntity) {
                        EntityId id = ((BasicEntity) arg).getId();
                        if (id.getId() == null) {
                            id.setId(sequencerTool.getNewId(arg));
                        }
                    }
                }
        );
        return joinPoint.proceed();
    }
}
