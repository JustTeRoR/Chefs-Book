package com.haerful.foodapp.view.home;

import com.haerful.foodapp.model.Category;
import com.haerful.foodapp.model.Meal;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meal> meal);
    void setCategory(List<Category> category);
    void onErrorLoading(String message);
}
