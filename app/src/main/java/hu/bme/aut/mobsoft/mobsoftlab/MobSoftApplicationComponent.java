package hu.bme.aut.mobsoft.mobsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.InteractorModule;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.CategoriesInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.EventsInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.FavouritesInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.LoginInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.mock.MockNetworkModule;
import hu.bme.aut.mobsoft.mobsoftlab.network.NetworkModule;
import hu.bme.aut.mobsoft.mobsoftlab.repository.RepositoryModule;
import hu.bme.aut.mobsoft.mobsoftlab.ui.UIModule;
import hu.bme.aut.mobsoft.mobsoftlab.ui.categories.CategoriesActivity;
import hu.bme.aut.mobsoft.mobsoftlab.ui.categories.CategoriesPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventDetailsActivity;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventDetailsPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventsListActivity;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventsListPresenter;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainActivity;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, MockNetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(CategoriesActivity activity);
    void inject(EventsListActivity activity);
    void inject(EventDetailsActivity activity);

    void inject(FavouritesInteractor favouritesInteractor);

    void inject(EventsInteractor interactor);

    void inject(LoginInteractor interactor);

    void inject(CategoriesInteractor interactor);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainPresenter mainPresenter);

    void inject(CategoriesPresenter presenter);
    void inject(EventsListPresenter presenter);
    void inject(EventDetailsPresenter presenter);
}
