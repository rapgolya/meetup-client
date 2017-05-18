package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.model.EventComments;
import hu.bme.aut.mobsoft.mobsoftlab.model.Todo;

public class MemoryRepository implements Repository {

	private static final long MINUTE = 60 * 1000;

	public static List<Event> events;
	public static List<Category> categories;
	public static List<EventComments> comments;

	@Override
	public void open(Context context) {
		events = new ArrayList<>();
		events.add(new Event(1L, 20, "Lorem ipsum", "4:30", "BME", "free", "Test Event", "12:00", "", 200 ));
		events.add(new Event(2L, 20, "Lorem ipsum", "4:30", "BME", "free", "Test Event", "12:00", "", 200 ));
		events.add(new Event(3L, 20, "Lorem ipsum", "4:30", "BME", "free", "Test Event", "12:00", "", 200 ));
		events.add(new Event(4L, 20, "Lorem ipsum", "4:30", "BME", "free", "Test Event", "12:00", "", 200 ));
		categories = new ArrayList<>();
		categories.add(new Category(1L, "Informatika", "IT"));
		categories.add(new Category(1L, "Gasztronómia", "IT"));
		categories.add(new Category(1L, "Tánc", "IT"));
		categories.add(new Category(1L, "Kutya", "IT"));
	}

	@Override
	public void close() {

	}

	@Override
	public List<Category> getCategories(){
		return this.categories;
	}
	@Override
	public List<Event> getFavourites() {
		return events;
	}

	@Override
	public void saveFavourite(Event event) {

	}

	@Override
	public void updateFavourites(List<Event> events) {

	}

	@Override
	public void removeFavourite(Event event) {

	}

	@Override
	public boolean isInDB(Event event) {
		return true;
	}

}

