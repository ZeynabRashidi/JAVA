package com.cbs.framework.inferstructure;

import com.cbs.framework.event.BaseEvent;
import com.cbs.framework.event.EventModel;

import java.util.List;

public interface EventStore {
    EventModel saveEvents(String aggregateIdentifier , Iterable<BaseEvent> events, int expectedVersion);

    List<BaseEvent> getEvents(String aggregateIdentifier);

}
