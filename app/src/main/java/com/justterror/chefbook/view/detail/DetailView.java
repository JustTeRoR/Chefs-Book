package com.justterror.chefbook.view.detail;

import com.justterror.chefbook.model.Meal;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(Meal meal);
    void onErrorLoading(String message);
}
