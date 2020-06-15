package com.justterror.chefbook.view.category;

import com.justterror.chefbook.model.Meal;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meal> meals);
    void onErrorLoading(String message);
}
