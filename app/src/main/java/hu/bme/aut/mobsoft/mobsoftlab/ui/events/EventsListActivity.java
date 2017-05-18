package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventsListActivity extends AppCompatActivity implements EventsListScreen {

    @Inject
    EventsListPresenter eventsListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_list);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventsListPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventsListPresenter.detachScreen();
    }

}
