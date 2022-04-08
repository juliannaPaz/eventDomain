package com.event.domain.eventdispatcher.events;

import com.event.domain.eventdispatcher.entity.Benefit;
import com.event.domain.eventdispatcher.interfaces.Event;
import com.google.gson.Gson;

import java.time.LocalDateTime;

public class BenefitRegistered implements Event {

    private LocalDateTime dateTimeOccurred;
    private Benefit benefit;
    private EventType eventType = EventType.BENEFIT_REGISTERED;

    @Override
    public void registerEvent(String payload) {
            this.dateTimeOccurred = LocalDateTime.now();
            this.benefit = convert(payload);
    }

    public LocalDateTime getDateTimeOccurred() {
        return dateTimeOccurred;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public EventType getEventType() {
        return eventType;
    }

    private Benefit convert(String payload){
        Gson gson = new Gson();
        return gson.fromJson(payload, Benefit.class);
    }

}
