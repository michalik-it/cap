package com.stanusch.omnibot.rest.repository.model;

import com.stanusch.omnibot.rest.repository.model.id.FactId;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Fact {
    @EmbeddedId
    private FactId id;

    private String name;
    private String content;
}