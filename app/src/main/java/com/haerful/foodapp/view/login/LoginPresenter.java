package com.haerful.foodapp.view.login;

import android.support.annotation.NonNull;

import com.haerful.foodapp.Utils;

import java.nio.file.attribute.UserPrincipal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void getLoginInfo(String username, String password) {

        view.showLoading();
        Call<UserPrincipal> mealsCall = Utils.getApi().loginUser(username, password);
        mealsCall.enqueue(new Callback<UserPrincipal>() {
            @Override
            public void onResponse(@NonNull Call<UserPrincipal> call, @NonNull Response<UserPrincipal> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    String userJWTtoken = response.headers().get("Authorization");
                    view.getLoginInfo(userJWTtoken);
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserPrincipal> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}
