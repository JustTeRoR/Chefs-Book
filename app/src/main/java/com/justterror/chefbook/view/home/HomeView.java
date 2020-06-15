package com.justterror.chefbook.view.home;

import com.justterror.chefbook.model.Category;
import com.justterror.chefbook.model.Meal;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meal> meal);
    void setCategory(List<Category> category);
    void onErrorLoading(String message);
}
