package com.stanusch.omnibot.rest.repository.model;

import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BasicEntity {
    @EmbeddedId
    EntityId id;
}
