package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventDetailsActivity extends AppCompatActivity implements EventDetailsScreen {

    @Inject
    EventDetailsPresenter eventDetailsPresenter;

    private Event selectedEvent;

    private TextView eventTitle;
    private TextView eventDate;
    private TextView eventLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);
        MobSoftApplication.injector.inject(this);

        eventTitle = (TextView) findViewById(R.id.eventTitle);
        eventDate = (TextView) findViewById(R.id.eventDate);
        eventLocation = (TextView) findViewById(R.id.eventLocation);
        Button navigateButton = (Button) findViewById(R.id.navigateButton);
        final EventDetailsActivity that = this;
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + that.selectedEvent.getVenue();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventDetailsPresenter.attachScreen(this);
        Intent intent = getIntent();
        Long eventId = intent.getLongExtra("eventId", 0L);
        eventDetailsPresenter.getEvent(eventId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventDetailsPresenter.detachScreen();
    }

    @Override
    public void onEventChanged(Event event) {
        selectedEvent = event;
        updateBinding();
    }

    private void updateBinding(){
        eventTitle.setText(selectedEvent.getName());
        eventDate.setText(selectedEvent.getTime());
        eventLocation.setText(selectedEvent.getVenue());
    }
}
