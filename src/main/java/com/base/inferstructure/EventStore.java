package com.base.inferstructure;

import com.base.event.BaseEvent;
import com.base.event.EventModel;

import java.util.List;

public interface EventStore {
    EventModel saveEvents(String aggregateIdentifier , Iterable<BaseEvent> events, int expectedVersion);

    List<BaseEvent> getEvents(String aggregateIdentifier);

}
