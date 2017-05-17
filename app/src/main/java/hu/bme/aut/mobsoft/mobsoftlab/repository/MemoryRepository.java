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

	}

	@Override
	public void close() {

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

