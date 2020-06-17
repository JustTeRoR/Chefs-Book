package com.haerful.foodapp.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.haerful.foodapp.R;
import com.haerful.foodapp.Utils;
import com.haerful.foodapp.api.FoodClient;
import com.haerful.foodapp.view.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.loginButton)
    Button loginButton;

    @BindView(R.id.input_username)
    EditText inputUsername;

    @BindView(R.id.input_password)
    EditText inputPassword;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);


        loginButton.setOnClickListener((view) -> {
            String username = inputUsername.getText().toString();
            String password = inputPassword.getText().toString();
            presenter.getLoginInfo(username, password);

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }


    @Override
    public void showLoading() {
        //TODO update later here
    }

    @Override
    public void hideLoading() {
        //TODO update later here
    }

    @Override
    public void getLoginInfo(String userJWTtoken) {
        FoodClient.token = userJWTtoken;
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Title", message);
    }
}
