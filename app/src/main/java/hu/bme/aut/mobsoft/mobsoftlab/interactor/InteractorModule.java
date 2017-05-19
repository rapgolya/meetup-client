package hu.bme.aut.mobsoft.mobsoftlab.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.CategoriesInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.EventsInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.LoginInteractor;

@Module
public class InteractorModule {

	@Provides
	public LoginInteractor provideLogin() {
		return new LoginInteractor();
	}

	@Provides
	public CategoriesInteractor provideCategory() {
		return new CategoriesInteractor();
	}

	@Provides
	public EventsInteractor provideEvents() {
		return new EventsInteractor();
	}

}
