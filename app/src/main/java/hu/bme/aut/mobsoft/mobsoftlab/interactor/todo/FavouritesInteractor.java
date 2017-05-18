package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetFavouritesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.RemoveFavouriteEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.SaveFavouriteEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.model.Todo;
import hu.bme.aut.mobsoft.mobsoftlab.network.todo.MeetUpApi;
import hu.bme.aut.mobsoft.mobsoftlab.repository.Repository;


public class FavouritesInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    MeetUpApi meetUpApi;


    public FavouritesInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getFavourites() {
        GetFavouritesEvent event = new GetFavouritesEvent();
        try {
            List<Event> events = repository.getFavourites();
            event.setEvents(events);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveFavourite(Event event) {

        SaveFavouriteEvent ev = new SaveFavouriteEvent();
        ev.setEvent(event);
        try {
            meetUpApi.saveFavourite(event).execute();
            repository.saveFavourite(event);
            bus.post(event);
        } catch (Exception e) {
            ev.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateFavourites(List<Event> events) {
        try {
            repository.updateFavourites(events);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeFavourites(Event event) {
        RemoveFavouriteEvent ev = new RemoveFavouriteEvent();
        ev.setEvent(event);
        try {
            repository.removeFavourite(event);
            bus.post(event);
        } catch (Exception e) {
            ev.setThrowable(e);
            bus.post(event);
        }
    }
}
