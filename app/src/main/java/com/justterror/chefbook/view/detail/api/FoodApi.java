/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 6/15/20 6:00 PM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.justterror.chefbook.view.detail.api;

import com.justterror.chefbook.view.detail.model.Category;
import com.justterror.chefbook.view.detail.model.Meal;

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
