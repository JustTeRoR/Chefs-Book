package ru.vsu.chefsbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.vsu.chefsbook.ui.FavouriteMeals.FavouriteMealsActivity;
import ru.vsu.chefsbook.ui.SearchMeal.SearchMealActivity;
import ru.vsu.chefsbook.ui.SingIn.SingInActivity;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;



public class MainActivity extends AppCompatActivity {

    Context executionContext = this;
    BottomNavigationView bottomNavigation;

    private GoogleSignInClient googleSignInClient;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            bottomNavigation = findViewById(R.id.bottom_navigation);
            bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);



    }




    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent intent;
                    switch (item.getItemId()) {
                        case R.id.navigation_favourites:
                            intent = new Intent(executionContext,FavouriteMealsActivity.class);
                            startActivity(intent);
                            return true;
                        case R.id.navigation_search:
                            return true;
                        case R.id.navigation_shoppingList:
                            //Intent intent = new Intent(this, ShoppingListActivity.class);
                            //startActivity(intent);
                    }
                    return false;
                }
            };

}
