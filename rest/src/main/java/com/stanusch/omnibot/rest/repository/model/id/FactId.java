package com.stanusch.omnibot.rest.repository.model.id;

import javax.persistence.Embeddable;

@Embeddable
public class FactId extends EntityId{
    @Override
    public String toString() {
        return "/search/findById?botId="+getBotId()+"&factId="+getId();
    }
}
