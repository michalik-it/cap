package com.stanusch.omnibot.rest.repository.model;

import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Fact {
    @EmbeddedId
    private EntityId id;

    private String name;
    private String content;
}