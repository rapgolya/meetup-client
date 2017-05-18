package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.EventsInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.LoginInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetCategoriesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetEventsByCategoryEvent;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainScreen;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventsListPresenter extends Presenter<EventsListScreen> {

    @Inject
    EventsInteractor eventsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    @Override
    public void attachScreen(EventsListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getEventsByCategoryId(final Long categoryId){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                eventsInteractor.getEventsByCategory(categoryId);
            }
        });
    }

    public void onEventMainThread(GetEventsByCategoryEvent e) {
        Log.d("test","test");
        if (e.getThrowable() != null) {
            e.getThrowable().printStackTrace();
            if (screen != null) {
            }
            Log.e("Networking", "Error reading favourites", e.getThrowable());
        } else {
            if (screen != null) {
                screen.onEventsChange(e.getEvents());
            }
        }
    }


}
