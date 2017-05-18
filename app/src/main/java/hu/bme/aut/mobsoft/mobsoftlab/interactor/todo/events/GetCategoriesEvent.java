package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Category;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class GetCategoriesEvent {
    private List<Category> categories;
    private Throwable throwable;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
