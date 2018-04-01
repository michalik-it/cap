package com.stanusch.omnibot.rest.repository.model.id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class EntityId implements Serializable {

    @Column(name = "ido", nullable = false)
    private Long id;

    @Column(name = "idb", nullable = false)
    private Long botId;

}
