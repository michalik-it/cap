package com.stanusch.omnibot.rest.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Fact extends BasicEntity {
    private String name;
    private String content;
}