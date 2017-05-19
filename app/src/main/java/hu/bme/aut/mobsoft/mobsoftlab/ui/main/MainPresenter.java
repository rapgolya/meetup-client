package hu.bme.aut.mobsoft.mobsoftlab.ui.main;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.LoginInteractor;
import hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events.LoginEvent;
import hu.bme.aut.mobsoft.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication.injector;


public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    LoginInteractor loginInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
		bus.unregister(this);
        super.detachScreen();
    }

    public void login(final String email, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                loginInteractor.login(email, password);
            }
        });
    }


    public void onEventMainThread(LoginEvent e) {
        Log.d("test","test");
        if (e.getThrowable() != null) {
            e.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", e.getThrowable());
        } else {
            if (screen != null) {
                screen.login();
            }
        }
    }

}
