package com.haerful.foodapp.view.category;

import com.haerful.foodapp.model.Meal;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meal> meals);
    void onErrorLoading(String message);
}
