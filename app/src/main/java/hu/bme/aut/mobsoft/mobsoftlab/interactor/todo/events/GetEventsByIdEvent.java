package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class GetEventsByIdEvent {
    private Event event;
    private Throwable throwable;
    private Long eventId;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Long geteventId() {
        return eventId;
    }

    public void setCeventId(Long eventId) {
        this.eventId = eventId;
    }
}
