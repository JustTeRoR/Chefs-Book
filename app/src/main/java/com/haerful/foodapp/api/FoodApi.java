package com.haerful.foodapp.api;

import com.haerful.foodapp.model.Category;
import com.haerful.foodapp.model.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {
    //using this because don't have rights for full subscribe of API
    @GET("meal/")
    Call<List<Meal>> getMeal();


    @GET("category/")
    Call<List<Category>> getCategories();

    @GET("meal/")
    Call<List<Meal>> getMealByCategory(@Query(value = "category",encoded = false) String category);


    @GET("meal/")
    Call<List<Meal>> getMealByName(@Query(value = "search",encoded = false) String mealName);
}
