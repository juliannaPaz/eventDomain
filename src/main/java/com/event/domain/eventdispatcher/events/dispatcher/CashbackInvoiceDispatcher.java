package com.event.domain.eventdispatcher.events.dispatcher;

import com.event.domain.eventdispatcher.events.EventType;
import com.event.domain.eventdispatcher.interfaces.Event;
import com.event.domain.eventdispatcher.interfaces.EventDispatcher;
import com.event.domain.eventdispatcher.interfaces.EventHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CashbackInvoiceDispatcher implements EventDispatcher {

    private LinkedList<EventHandler> eventHandlers = new LinkedList<>();
    private EventType eventType;
    private List<CashbackInvoiceDispatcher> eventDispatchers = new ArrayList<>();

    public CashbackInvoiceDispatcher() {
    }

    public CashbackInvoiceDispatcher(final EventType eventType , final LinkedList<EventHandler> eventHandlers) {
        this.eventType = eventType;
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void register(final EventType eventType, final EventHandler eventHandler) {
        var eventDispatcher = eventDispatchers
            .stream().filter(ed -> ed.eventType.equals(eventType)).findFirst();

        if(eventDispatcher.isPresent()){
            eventDispatcher.get().eventHandlers.add(eventHandler);
            return;
        }

        eventDispatchers.add(new CashbackInvoiceDispatcher(eventType, new LinkedList<>(List.of(eventHandler))));
    }

    @Override
    public void notify(final Event event) {
        getEventHandlers(event.getEventType()).forEach(handler -> handler.handle(event));
    }

    public List<EventHandler> getEventHandlers(EventType eventType) {
        return eventDispatchers.stream().filter(ed -> ed.eventType.equals(eventType)).findFirst().get().eventHandlers;
    }
}
