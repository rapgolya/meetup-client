package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

public class GetFavouritesEvent {
	private int code;
	private List<Event> events;
	private Throwable throwable;

	public GetFavouritesEvent(int code, List<Event> events, Throwable throwable) {
		this.code = code;
		this.events = events;
		this.throwable = throwable;
	}


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Event> getEvents() {
        return new ArrayList<Event>();
        //return events;
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

    public GetFavouritesEvent() {
	}
}
