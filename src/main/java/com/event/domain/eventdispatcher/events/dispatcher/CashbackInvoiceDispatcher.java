package com.event.domain.eventdispatcher.events.dispatcher;

import com.event.domain.eventdispatcher.events.EventType;
import com.event.domain.eventdispatcher.interfaces.Event;
import com.event.domain.eventdispatcher.interfaces.EventDispatcher;
import com.event.domain.eventdispatcher.interfaces.EventHandler;

import java.util.LinkedList;
import java.util.List;

public class CashbackInvoiceDispatcher implements EventDispatcher {

    private LinkedList<EventHandler> eventHandlers = new LinkedList<>();

    @Override
    public void register(final EventType eventType, final EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    @Override
    public void notify(final Event event) {
        eventHandlers.forEach(eventHandler -> eventHandler.handle(event));
    }

    public List<EventHandler> getEventHandlers() {
        return eventHandlers;
    }

}
