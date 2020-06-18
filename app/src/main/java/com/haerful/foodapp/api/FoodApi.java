package com.haerful.foodapp.api;

import com.haerful.foodapp.model.Category;
import com.haerful.foodapp.model.Meal;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodApi {
    //using this because don't have rights for full subscribe of API
    @GET("meal/")
    Call<List<Meal>> getMeal();


    @GET("category/")
    Call<List<Category>> getCategories();

    @GET("meal/mealCategory/category={category}")
    Call<List<Meal>> getMealByCategory(@Path(value = "category") String category);


    @GET("meal/search={query}")
    Call<List<Meal>> getMealByName(@Path(value = "query",encoded = false) String mealName);

    @GET("user/login")
    Call<ResponseBody> loginUser(@Query(value = "name", encoded = false) String username, @Query(value = "password", encoded = false) String password);
}
