package com.event.domain.eventdispatcher.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Benefit {

    private UUID id;
    private String campaignName;
    private BigDecimal value;

    public Benefit(final UUID id, final String campaignName, final BigDecimal value) {
        this.id = id;
        this.campaignName = campaignName;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public BigDecimal getValue() {
        return value;
    }
}
