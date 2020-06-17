package com.haerful.foodapp.view.login;

import com.haerful.foodapp.model.Meal;

public interface LoginView {
    void showLoading();
    void hideLoading();
    void setLoginInfo(Meal meal);
    void onErrorLoading(String message);
}
