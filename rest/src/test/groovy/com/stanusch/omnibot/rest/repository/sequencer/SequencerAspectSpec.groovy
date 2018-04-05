package com.stanusch.omnibot.rest.repository.sequencer

import com.stanusch.omnibot.rest.repository.model.Fact
import com.stanusch.omnibot.rest.repository.model.id.EntityId
import org.aspectj.lang.ProceedingJoinPoint
import spock.lang.Specification

class SequencerAspectSpec extends Specification {
    def sequencerTool = Mock(SequencerTool)
    def subject = new SequencerAspect(sequencerTool)
    def joinPoint = Mock(ProceedingJoinPoint)
    def fact = new Fact()
    def id = new EntityId()

    def "generateId: when argument is instance of BasicEntity and id is null then generate and set new id"() {
        given:
        id.setBotId(123)
        id.setId(null)
        fact.setId(id)
        joinPoint.getArgs() >> [fact]
        sequencerTool.getNewId(fact) >> 999

        when:
        subject.generateId(joinPoint)

        then:
        fact.getId().getId() == 999
    }
}
