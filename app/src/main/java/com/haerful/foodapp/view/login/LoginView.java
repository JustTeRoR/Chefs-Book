package com.haerful.foodapp.view.login;

import com.haerful.foodapp.model.Meal;

public interface LoginView {
    void showLoading();
    void hideLoading();
    void getLoginInfo(String token);
    void onErrorLoading(String message);
}
