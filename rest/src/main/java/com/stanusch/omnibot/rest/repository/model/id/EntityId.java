package com.stanusch.omnibot.rest.repository.model.id;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class EntityId implements Serializable {

    @Column(name = "ido", nullable = false)
    private Long id;

    @Column(name = "idb", nullable = false)
    private Long botId;

}
