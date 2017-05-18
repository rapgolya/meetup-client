package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.model.Todo;

public interface Repository {

    void open(Context context);

    void close();

    List<Event> getFavourites();

    void saveFavourite(Event event);

    void updateFavourites(List<Event> events);

    void removeFavourite(Event event);

    boolean isInDB(Event event);

    List<Category> getCategories();
    Event getEventById(Long eventId);
    List<Event> getEventsByCategoryId(Long categoryId);
}
