package ru.vsu.chefsbook;

import android.app.Application;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import ru.vsu.chefsbook.ui.main.MainActivity;

public class App extends Application {

    private static App instance;

    //TODO: Update url to the api here when in will be finished
    public static final String BASE_URL = "";

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if (account != null) {
            Intent intent = new Intent(App.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }


    public static String getUserCode() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(App.getInstance().getApplicationContext());
        if (account != null)
            return account.getId();
        return null;
    }
}
