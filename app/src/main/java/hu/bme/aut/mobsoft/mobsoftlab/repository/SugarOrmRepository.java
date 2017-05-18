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
    public List<Event> getFavourites() {
        return SugarRecord.listAll(Event.class);
    }

    @Override
    public void saveFavourite(Event event) {
        SugarRecord.saveInTx(event);
    }

    @Override
    public void updateFavourites(List<Event> events) {
        List<Event> favourites = getFavourites();
        List<Event> toUpdate = new ArrayList<>(favourites.size());
        for (Event favourite : favourites) {
            for (Event event : events) {
                if (event.getId().equals(favourite.getId())) {
                    toUpdate.add(event);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeFavourite(Event event) {
        SugarRecord.deleteInTx(event);
    }

    @Override
    public boolean isInDB(Event event) {
        return SugarRecord.findById(Todo.class, event.getId()) != null;
    }

    public List<Category> getCategories() {
        return SugarRecord.listAll(Category.class);
    }

}
