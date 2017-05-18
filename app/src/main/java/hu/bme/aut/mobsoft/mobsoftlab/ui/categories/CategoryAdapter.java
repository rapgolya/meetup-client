package hu.bme.aut.mobsoft.mobsoftlab.ui.categories;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Category;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CategoryAdapter(Context context, int resource, List<Category> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listItem = inflater.inflate(R.layout.category_list_item, parent, false);
        Category category = getItem(position);

        TextView historyItemNameAndAmount = (TextView) listItem.findViewById(R.id.categoryName);

        historyItemNameAndAmount.setText(category.getName());

        return listItem;
    }
}
