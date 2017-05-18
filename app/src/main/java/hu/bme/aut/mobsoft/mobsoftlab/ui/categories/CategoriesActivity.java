package hu.bme.aut.mobsoft.mobsoftlab.ui.categories;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.mobsoftlab.R;
import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.ui.events.EventsListActivity;
import hu.bme.aut.mobsoft.mobsoftlab.ui.main.MainPresenter;


public class CategoriesActivity extends AppCompatActivity implements CategoriesScreen {

    @Inject
    CategoriesPresenter categoryPresenter;

    private ListView categoryListView = null;

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        MobSoftApplication.injector.inject(this);

        categoryListView = (ListView) findViewById(R.id.categoryList);
        final CategoriesActivity that = this;
        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(that, EventsListActivity.class);
                intent.putExtra("categoryId", ((Category)parent.getItemAtPosition(position)).getId());
                startActivity(intent);
            }
        });
        // Obtain the shared Tracker instance.
        //MobSoftApplication application = (MobSoftApplication) getApplication();
        //mTracker = application.getDefaultTracker();

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        categoryPresenter.attachScreen(this);
        //mTracker.setScreenName("Image~CategoryActivity");
        //mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        categoryPresenter.getCategories();
    }

    @Override
    protected void onStop() {
        super.onStop();
        categoryPresenter.detachScreen();
    }

    @Override
    public void onCategoriesChange(List<Category> categoryList){
        categoryListView.setAdapter(new CategoryAdapter(this, R.layout.category_list_item, categoryList));
    }

}
