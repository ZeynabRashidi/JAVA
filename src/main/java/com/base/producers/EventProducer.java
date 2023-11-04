package com.base.producers;

import com.base.event.BaseEvent;

public interface EventProducer {
    void  produce(String topic, BaseEvent event);

}
