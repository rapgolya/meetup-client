package hu.bme.aut.mobsoft.mobsoftlab.ui.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class EventsAdapter extends ArrayAdapter<Event> {

    public EventsAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public EventsAdapter(Context context, int resource, List<Event> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listItem = inflater.inflate(R.layout.category_list_item, parent, false);
        Event event = getItem(position);

        TextView historyItemNameAndAmount = (TextView) listItem.findViewById(R.id.categoryName);

        historyItemNameAndAmount.setText(event.getName());

        return listItem;
    }
}
