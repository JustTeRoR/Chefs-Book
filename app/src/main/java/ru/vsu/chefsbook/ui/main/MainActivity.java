package ru.vsu.chefsbook.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.vsu.chefsbook.App;
import ru.vsu.chefsbook.R;
import ru.vsu.chefsbook.ui.FavouriteMeals.FavouriteMealsActivity;
import ru.vsu.chefsbook.ui.SingIn.SignInActivity;


import com.google.android.gms.auth.api.signin.GoogleSignInClient;


public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SETTINGS_SHARED_PREF";
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigation;
    private GoogleSignInClient googleSignInClient;
    private SharedPreferences settingsSharedPreferences;

    Context executionContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        //bottomNavigation.setSelectedItemId(R.id.navigation_search);

        settingsSharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent intent;
                    switch (item.getItemId()) {
                        case R.id.navigation_favourites:
                            intent = new Intent(executionContext, FavouriteMealsActivity.class);
                            startActivity(intent);
                            return true;
                        case R.id.navigation_search:
                            return true;
                        case R.id.navigation_shoppingList:
                            //TODO: Update this method with fragments or intents
                    }
                    return false;
                }
    };

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        if (App.getUserCode() == null) {
            menu.findItem(R.id.signInSettings).setVisible(true);
            menu.findItem(R.id.signOutSettings).setVisible(false);
        } else {
            menu.findItem(R.id.signInSettings).setVisible(false);
            menu.findItem(R.id.signOutSettings).setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.signInSettings:
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                return true;
            case R.id.signOutSettings:
                signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void signOut() {
        googleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast toast = Toast.makeText(MainActivity.this, R.string.successfullySignedOut, Toast.LENGTH_SHORT);
                        toast.setMargin(0, 0.1f);
                        toast.show();
                        invalidateOptionsMenu();
                        startActivity(new Intent(MainActivity.this, SignInActivity.class));
                    }
                });
    }
}
