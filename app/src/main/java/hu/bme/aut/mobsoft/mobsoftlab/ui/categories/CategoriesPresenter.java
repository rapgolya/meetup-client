package hu.bme.aut.mobsoft.mobsoftlab.ui.categories;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.CategoriesInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetCategoriesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.GetFavouritesEvent;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class CategoriesPresenter extends Presenter<CategoriesScreen> {
    @Inject
    CategoriesInteractor categoriesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    @Override
    public void attachScreen(CategoriesScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getCategories() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoriesInteractor.getCategories();
            }
        });
    }

    public void onEventMainThread(GetCategoriesEvent e) {
        Log.d("test","test");
        if (e.getThrowable() != null) {
            e.getThrowable().printStackTrace();
            if (screen != null) {
            }
            Log.e("Networking", "Error reading favourites", e.getThrowable());
        } else {
            if (screen != null) {
                screen.onCategoriesChange(e.getCategories());
            }
        }
    }
}
