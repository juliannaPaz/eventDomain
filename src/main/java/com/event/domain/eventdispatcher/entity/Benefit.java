package com.event.domain.eventdispatcher.entity;

import com.event.domain.eventdispatcher.events.BenefitRegistered;
import com.event.domain.eventdispatcher.interfaces.Event;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Benefit {

    private UUID id;
    private String campaignName;
    private BigDecimal value;
    private List<Event> events;

    public Benefit(final UUID id, final String campaignName, final BigDecimal value) {
        this.id = id;
        this.campaignName = campaignName;
        this.value = value;
        events.add(new BenefitRegistered());
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
