package com.stanusch.omnibot.rest.repository.sequencer

import com.stanusch.omnibot.rest.exception.SequenceNotFoundException
import com.stanusch.omnibot.rest.repository.model.Fact
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.Query

class SequencerToolSpec extends Specification {
    def subject = new SequencerTool()
    def em = Mock(EntityManager)
    def query = Mock(Query)

    def setup() {
        subject.entityManager = em
    }

    def "getNewId: when sequence does not exist then throw SequenceNotFoundException"() {
        when:
        subject.getNewId("Dummy string")

        then:
        def e = thrown(SequenceNotFoundException)
        e.getSequenceName() == "String"
    }

    def "getNewId: when sequence exists then select next value from sequence"() {
        given:
        em.createNativeQuery("select nextval('{h-schema}fact_ido_seq')") >> query
        query.getSingleResult() >> new BigInteger(123)

        when:
        def id = subject.getNewId(new Fact())

        then:
        notThrown(SequenceNotFoundException)
        id == 123L
    }
}
