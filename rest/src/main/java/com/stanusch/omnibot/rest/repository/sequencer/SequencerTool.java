package com.stanusch.omnibot.rest.repository.sequencer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Component
@Slf4j
public class SequencerTool {

    private static final String SELECT_NEXTVAL_TEMPLATE = "select nextval('{h-schema}%s')";
    private static final String BUNDLE_NAME = "sequencer";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    @PersistenceContext
    private EntityManager entityManager;

    Long getNewId(Object entity) {
        String simpleName = entity.getClass().getSimpleName();
        String seqName = this.getString(simpleName.toLowerCase());
        if (seqName == null) {
            log.error("Brak zdefiniowanego sequencera {} w {}",simpleName, RESOURCE_BUNDLE.getBaseBundleName());
            throw new RuntimeException("Brak zdefiniowanego sequencera " + simpleName + " w " + RESOURCE_BUNDLE.getBaseBundleName());
        } else {
            String select = String.format(SELECT_NEXTVAL_TEMPLATE, seqName);
            Query nativeQuery = entityManager.createNativeQuery(select);
            BigInteger ido = (BigInteger) nativeQuery.getSingleResult();
            return ido.longValue();
        }

    }

    private String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }
}
