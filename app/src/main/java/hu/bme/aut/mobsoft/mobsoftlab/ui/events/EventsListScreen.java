package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public interface EventsListScreen {
    void onEventsChange(List<Event> events);

}
