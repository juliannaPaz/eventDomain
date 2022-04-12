package com.event.domain.eventdispatcher.interfaces;

import com.event.domain.eventdispatcher.events.EventType;

public abstract class Event {
    private EventType eventType;
    public abstract void registerEvent(String payload);

    public Event(final EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

}
