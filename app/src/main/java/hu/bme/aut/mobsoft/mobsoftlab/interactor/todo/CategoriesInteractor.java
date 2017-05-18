package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetCategoriesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetFavouritesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.network.todo.MeetUpApi;
import hu.bme.aut.mobsoft.mobsoftlab.repository.Repository;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class CategoriesInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    MeetUpApi meetUpApi;

    public CategoriesInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCategories() {
        GetCategoriesEvent event = new GetCategoriesEvent();
        try {
            List<Category> categories = meetUpApi.getCategories().execute().body();
            event.setCategories(categories);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
