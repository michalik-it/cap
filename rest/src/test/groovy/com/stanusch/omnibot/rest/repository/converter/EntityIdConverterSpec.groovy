package com.stanusch.omnibot.rest.repository.converter

import com.stanusch.omnibot.rest.repository.model.Fact
import com.stanusch.omnibot.rest.repository.model.id.EntityId
import spock.lang.Specification

class EntityIdConverterSpec extends Specification {
    def subject = new EntityIdConverter();

    def "fromRequestId: when id is null then return null"() {
        when:
        def id = subject.fromRequestId(null, String.class)

        then:
        id == null
    }

    def "fromRequestId: when aClass does not extend BasicEntity and id is not null then return id as Long"() {
        when:
        def id = subject.fromRequestId("123", String.class)

        then:
        id == 123L
    }

    def "fromRequestId: when aClass extends BasicEntity then return id as EntityId"() {
        when:
        def id = subject.fromRequestId("2-123", Fact.class)

        then:
        def expectedId = new EntityId()
        expectedId.setId(123L)
        expectedId.setBotId(2L)
        id == expectedId
    }

    def "toRequestId: when aClass does not extend BasicEntity then return serializable as string"() {
        when:
        def idAsString = subject.toRequestId(2L, String.class)

        then:
        idAsString == "2"
    }

    def "toRequestId: when aClass extends BasicEntity then return formatted EntityId value"() {
        given:
        def id = new EntityId()
        id.setBotId(2L)
        id.setId(123L)

        when:
        def idAsString = subject.toRequestId(id, Fact.class)

        then:
        idAsString == "2-123"
    }

    def "supports: when aClass extends BasicEntity as id then return true"() {
        when:
        def result = subject.supports(Fact.class)

        then:
        result
    }

    def "supports: when aClass does not extend BasicEntity as id then return false"() {
        when:
        def result = subject.supports(String.class)

        then:
        !result
    }
}
