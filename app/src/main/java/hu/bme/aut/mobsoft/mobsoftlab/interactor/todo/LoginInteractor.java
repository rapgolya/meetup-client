package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetFavouritesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.LoginEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.RemoveFavouriteEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.SaveFavouriteEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.network.todo.MeetUpApi;
import hu.bme.aut.mobsoft.mobsoftlab.repository.Repository;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class LoginInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    MeetUpApi meetUpApi;


    public LoginInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(String userName, String password) {
        LoginEvent event = new LoginEvent(userName, password);
        try {
            meetUpApi.login(userName, password).execute();
            event.setSuccess(true);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            event.setSuccess(false);
            bus.post(event);
        }
    }
}
