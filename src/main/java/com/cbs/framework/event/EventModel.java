package com.cbs.framework.event;

import lombok.Data;

import java.util.Date;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Document(collection = "eventStore")
public class EventModel{
//    @Id
    private  String id;
    private Date timestamp;
    private String aggregateIdentifier;
    private  String aggregateType;
    private int version;
    private  String eventType;
    private BaseEvent eventData;

    EventModel(String id, Date timestamp, String aggregateIdentifier, String aggregateType, int version, String eventType, BaseEvent eventData) {
        this.id = id;
        this.timestamp = timestamp;
        this.aggregateIdentifier = aggregateIdentifier;
        this.aggregateType = aggregateType;
        this.version = version;
        this.eventType = eventType;
        this.eventData = eventData;
    }

    public static EventModelBuilder builder() {
        return new EventModelBuilder();
    }


    public static class EventModelBuilder {
        private String id;
        private Date timestamp;
        private String aggregateIdentifier;
        private String aggregateType;
        private int version;
        private String eventType;
        private BaseEvent eventData;

        EventModelBuilder() {
        }

        public EventModelBuilder id(String id) {
            this.id = id;
            return this;
        }

        public EventModelBuilder timestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public EventModelBuilder aggregateIdentifier(String aggregateIdentifier) {
            this.aggregateIdentifier = aggregateIdentifier;
            return this;
        }

        public EventModelBuilder aggregateType(String aggregateType) {
            this.aggregateType = aggregateType;
            return this;
        }

        public EventModelBuilder version(int version) {
            this.version = version;
            return this;
        }

        public EventModelBuilder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public EventModelBuilder eventData(BaseEvent eventData) {
            this.eventData = eventData;
            return this;
        }

        public EventModel build() {
            return new EventModel(id, timestamp, aggregateIdentifier, aggregateType, version, eventType, eventData);
        }

        public String toString() {
            return "EventModel.EventModelBuilder(id=" + this.id + ", timestamp=" + this.timestamp + ", aggregateIdentifier=" + this.aggregateIdentifier + ", aggregateType=" + this.aggregateType + ", version=" + this.version + ", eventType=" + this.eventType + ", eventData=" + this.eventData + ")";
        }
    }
}
