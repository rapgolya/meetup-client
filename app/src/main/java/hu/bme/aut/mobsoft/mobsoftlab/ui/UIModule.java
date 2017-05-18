package hu.bme.aut.mobsoft.mobsoftlab.ui;

import android.content.Context;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.ui.categories.CategoriesPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventDetailsPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventsListPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventsListScreen;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public CategoriesPresenter provideCategoriesPresenter() {
        return new CategoriesPresenter();
    }

    @Provides
    @Singleton
    public EventDetailsPresenter provideEventDetailsPresenter() {
        return new EventDetailsPresenter();
    }

    @Provides
    @Singleton
    public EventsListPresenter provideEventsListPresenter() {
        return new EventsListPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }


}
