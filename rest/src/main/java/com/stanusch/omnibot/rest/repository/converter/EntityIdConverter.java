package com.stanusch.omnibot.rest.repository.converter;

import com.stanusch.omnibot.rest.repository.model.BasicEntity;
import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class EntityIdConverter implements BackendIdConverter {
    private static final String SEPARATOR = "-";

    @Override
    public Serializable fromRequestId(String s, Class<?> aClass) {
        if (s == null) {
            return null;
        }
        if (!aClass.getSuperclass().equals(BasicEntity.class)) {
            return Long.parseLong(s);
        }
        EntityId entityId = new EntityId();
        String[] split = s.split(SEPARATOR);
        entityId.setBotId(Long.parseLong(split[0]));
        entityId.setId(Long.parseLong(split[1]));
        return entityId;
    }

    @Override
    public String toRequestId(Serializable serializable, Class<?> aClass) {
        if (!aClass.getSuperclass().equals(BasicEntity.class)) {
            return serializable.toString();
        }
        EntityId id = (EntityId) serializable;
        return String.format("%s-%s", id.getBotId(), id.getId());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getSuperclass().equals(BasicEntity.class);
    }

}
