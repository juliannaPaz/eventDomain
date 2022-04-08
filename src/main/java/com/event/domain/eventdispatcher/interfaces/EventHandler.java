package com.event.domain.eventdispatcher.interfaces;

public interface EventHandler<T extends Event> {

    void handle(T event);

}
