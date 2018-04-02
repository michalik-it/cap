package com.stanusch.omnibot.rest.repository.converter;

import com.stanusch.omnibot.rest.repository.model.Fact;
import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import lombok.extern.java.Log;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
@Log
public class EntityIdConverter implements BackendIdConverter {
    @PostConstruct
    public void init() {
        log.info("EntityIdConverter is here");
    }
    public static final String SEPARATOR = "-";

    @Override
    public Serializable fromRequestId(String s, Class<?> aClass) {
        if (s == null) return null;
        EntityId entityId = new EntityId();
        String[] split = s.split(SEPARATOR);
        entityId.setBotId(Long.parseLong(split[0]));
        entityId.setId(Long.parseLong(split[1]));
        return entityId;
    }

    @Override
    public String toRequestId(Serializable serializable, Class<?> aClass) {
        EntityId id = (EntityId) serializable;
        return String.format("%s-%s", id.getBotId(), id.getId());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Fact.class.equals(aClass);
    }

}
