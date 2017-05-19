package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.model.Todo;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public boolean isInDB(Event event) {
        return SugarRecord.findById(Todo.class, event.getId()) != null;
    }

    public List<Category> getCategories() {
        return SugarRecord.listAll(Category.class);
    }

    @Override
    public Event getEventById(Long eventId) {
        return SugarRecord.findById(Event.class, eventId);
    }

    @Override
    public List<Event> getEventsByCategoryId(Long categoryId) {
        return SugarRecord.findWithQuery(Event.class, "categoryId = ?", categoryId.toString());
    }

    @Override
    public Event setAttending(Long eventId, boolean attending) {
        Event event = getEventById(eventId);
        event.setYesRsvpCount(event.getYesRsvpCount() + (attending ?  +1 : -1));
        SugarRecord.save(event);
        return event;
    }

}
