package com.justterror.chefbook.api;

import com.justterror.chefbook.model.Category;
import com.justterror.chefbook.model.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {
    //using this because don't have rights for full subscribe of API
    @GET("meal/")
    Call<List<Meal>> getMeal();

    @GET("category/")
    Call<List<Category>> getCategories();

    @GET("category/")
    Call<List<Meal>> getMealByCategory(@Query("") String category);

    @GET("/")
    Call<List<Meal>> getMealByName(@Query("search") String mealName);
}
