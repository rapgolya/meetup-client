package hu.bme.aut.mobsoft.mobsoftlab.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.CategoriesInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.FavouritesInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.LoginInteractor;

@Module
public class InteractorModule {


	@Provides
	public FavouritesInteractor provideFavourites() {
		return new FavouritesInteractor();
	}

	@Provides
	public LoginInteractor provideLogin() {
		return new LoginInteractor();
	}

	@Provides
	public CategoriesInteractor provideCategory() {
		return new CategoriesInteractor();
	}

}
