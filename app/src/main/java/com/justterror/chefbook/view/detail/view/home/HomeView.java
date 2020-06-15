/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 6/15/20 6:00 PM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.justterror.chefbook.view.detail.view.home;

import com.justterror.chefbook.view.detail.model.Category;
import com.justterror.chefbook.view.detail.model.Meal;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meal> meal);
    void setCategory(List<Category> category);
    void onErrorLoading(String message);
}
