package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.ui.categories.CategoriesActivity;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventsListActivity extends AppCompatActivity implements EventsListScreen {

    @Inject
    EventsListPresenter eventsListPresenter;

    ListView eventsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_list);
        MobSoftApplication.injector.inject(this);

        eventsListView = (ListView) findViewById(R.id.eventsList);
        final EventsListActivity that = this;
        eventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(that, EventDetailsActivity.class);
                intent.putExtra("eventId", ((Event)parent.getItemAtPosition(position)).getId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        eventsListPresenter.attachScreen(this);
        Intent intent = getIntent();
        Long id = intent.getLongExtra("categoryId", 0L);
        eventsListPresenter.getEventsByCategoryId(id);
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventsListPresenter.detachScreen();
    }

    @Override
    public void onEventsChange(List<Event> events) {
        eventsListView.setAdapter(new EventsAdapter(this, R.layout.category_list_item, events));
    }
}
