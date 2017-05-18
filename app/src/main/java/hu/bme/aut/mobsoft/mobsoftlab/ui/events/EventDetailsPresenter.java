package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.EventsInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.LoginInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetCategoriesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetEventsByIdEvent;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventDetailsPresenter extends Presenter<EventDetailsScreen> {

    @Inject
    EventsInteractor eventsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    @Override
    public void attachScreen(EventDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    void getEvent(final Long id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                eventsInteractor.getEventById(id);
            }
        });
    }

    public void onEventMainThread(GetEventsByIdEvent e) {
        Log.d("test","test");
        if (e.getThrowable() != null) {
            e.getThrowable().printStackTrace();
            if (screen != null) {
            }
            Log.e("Networking", "Error reading favourites", e.getThrowable());
        } else {
            if (screen != null) {
                screen.onEventChanged(e.getEvent());
            }
        }
    }
}
