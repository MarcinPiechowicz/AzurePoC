package com.sap.corp.azurepoc;

import org.springframework.data.annotation.Id;

public class Event {

    @Id
    private Integer id;

    private String event;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event='" + event + '\'' +
                '}';
    }
}
