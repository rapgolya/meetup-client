package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;
 
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

public class RemoveFavouriteEvent {
	private int code;
	private Event event;
	private Throwable throwable;

	//<editor-fold desc="Constructors|Getters|Setters">

	public RemoveFavouriteEvent() {
	}

	public RemoveFavouriteEvent(int code, Event event, Throwable throwable) {
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

	public void setEvent(Event todos) {
		this.event = todos;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	//</editor-fold>
}
