package com.haerful.foodapp.view.detail;

import android.support.annotation.NonNull;

import com.haerful.foodapp.Utils;
import com.haerful.foodapp.model.Meal;

import java.nio.charset.StandardCharsets;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getMealById(String mealName) {
        
        view.showLoading();
        byte[] bytes = mealName.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedMealName = new String(bytes, StandardCharsets.UTF_8);

        Utils.getApi().getMealByName(utf8EncodedMealName)
                .enqueue(new Callback<List<Meal>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Meal>> call, @NonNull Response<List<Meal>> response) {
                        view.hideLoading();
                        if (response.isSuccessful() && response.body() != null) {
                            view.setMeal(response.body().get(0));
                        } else {
                            view.onErrorLoading(response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Meal>> call, @NonNull Throwable t) {
                        view.hideLoading();
                        view.onErrorLoading(t.getLocalizedMessage());
                    }
                });

    }
}
