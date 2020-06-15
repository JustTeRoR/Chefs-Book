package com.haerful.foodapp.view.detail;

import com.haerful.foodapp.model.Meal;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(Meal meal);
    void onErrorLoading(String message);
}
