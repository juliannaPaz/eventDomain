package com.event.domain.eventdispatcher.interfaces;

import com.event.domain.eventdispatcher.events.EventType;

public interface EventDispatcher {

    void register(EventType event, EventHandler eventHandler);
    void notify(Event event);


}
