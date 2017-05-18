package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventDetailsActivity extends AppCompatActivity implements EventDetailsScreen {

    @Inject
    EventDetailsPresenter eventDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventDetailsPresenter.detachScreen();
    }
}
