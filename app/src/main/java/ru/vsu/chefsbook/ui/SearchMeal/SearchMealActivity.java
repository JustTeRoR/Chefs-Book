package ru.vsu.chefsbook.ui.SearchMeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.vsu.chefsbook.R;
import ru.vsu.chefsbook.ui.FavouriteMeals.FavouriteMealsActivity;
//import ru.vsu.chefsbook.ui.ShoppingList.ShoppingListActivity;

public class SearchMealActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_meal);
        bottomNavigation = findViewById(R.id.bottom_navigation);
    }

    //Intent intent = new Intent(this, FavouriteMealsActivity.class);

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_favourites:

                            //startActivity(intent);
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
