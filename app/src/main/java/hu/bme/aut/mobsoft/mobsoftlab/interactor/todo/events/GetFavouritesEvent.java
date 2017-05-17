package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

public class GetFavouritesEvent {
	private int code;
	private List<Event> events;
	private Throwable throwable;

	//<editor-fold desc="Constructors|Getters|Setters">

	public GetFavouritesEvent() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Event> getTodos() {
		return events;
	}

	public void setTodos(List<Event> events) {
		this.events = events;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

//</editor-fold>
}
