package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class GetEventsByCategoryEvent {
    private List<Event> events;
    private Throwable throwable;
    private Long categoryId;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
