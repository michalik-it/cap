package com.stanusch.omnibot.rest.repository.model;

import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

/**
 * Each entity that uses EntityId as composed key should extend the class
 * It is used in {@link com.stanusch.omnibot.rest.repository.converter.EntityIdConverter}
 * and in {@link com.stanusch.omnibot.rest.repository.sequencer.SequencerAspect}
 */
@MappedSuperclass
@Data
public class BasicEntity {
    @EmbeddedId
    EntityId id;
}
