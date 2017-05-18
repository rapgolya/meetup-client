package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetCategoriesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetEventsByCategoryEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetEventsByIdEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.network.todo.MeetUpApi;
import hu.bme.aut.mobsoft.mobsoftlab.repository.Repository;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventsInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    MeetUpApi meetUpApi;


    public EventsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getEventsByCategory(Long categoryId) {
        GetEventsByCategoryEvent event = new GetEventsByCategoryEvent();
        try {
            List<Event> events = meetUpApi.getEventsByCategory(categoryId).execute().body();
            event.setEvents(events);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getEventById(Long eventId) {
        GetEventsByIdEvent event = new GetEventsByIdEvent();
        try {
            Event eventDto = meetUpApi.getEventById(eventId).execute().body();
            event.setEvent(eventDto);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
