package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;


import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

public class SaveFavouriteEvent {
	private int code;
	private Event event;
	private Throwable throwable;

	public SaveFavouriteEvent() {
	}

	public SaveFavouriteEvent(int code, Event event, Throwable throwable) {

		this.code = code;
		this.event = event;
		this.throwable = throwable;
	}

	public int getCode() {

		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

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

}
