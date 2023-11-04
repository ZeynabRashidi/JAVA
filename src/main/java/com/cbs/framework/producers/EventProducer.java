package com.cbs.framework.producers;

import com.cbs.framework.event.BaseEvent;

public interface EventProducer {
    void  produce(String topic, BaseEvent event);

}
