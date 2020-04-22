package ru.vsu.chefsbook.api.interfaces;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.vsu.chefsbook.api.entities.Meal;

public interface MealAPI {
    @GET("/meals")
    Call<List<Meal>> getMeals(@Query("name") String name, @Query("category") String category, @Query("country") String country, @Query("recipe") String recipe,
                        @Query("tags") String tags, @Query("ingredients") String ingredients, @Query("youTube_url") String youTube_url,
                        @Query("image") String imageUrl);
}
