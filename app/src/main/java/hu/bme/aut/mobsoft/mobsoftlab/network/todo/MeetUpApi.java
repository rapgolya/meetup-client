package hu.bme.aut.mobsoft.mobsoftlab.network.todo;

import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.model.Todo;


import retrofit2.Call;
import retrofit2.http.*;


public interface MeetUpApi {
  
  /**
   * Create a new instance of the model and persist it into the data source.
   * 
   * @param data Model instance data
   * @return Call<Void>
   */
  
  @POST("Event")
  Call<Void> saveFavourite(
    @Body Event data
  );

  @POST("Login")
  Call<Void> login(
          @Header("userName") String userName,
          @Header("passWord") String password
  );

  @GET("Categories")
  Call <List<Category>> getCategories();

  
}
