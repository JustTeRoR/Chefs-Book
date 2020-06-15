/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 6/15/20 6:00 PM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.justterror.chefbook.view.detail.view.detail;

import com.justterror.chefbook.view.detail.model.Meal;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(Meal meal);
    void onErrorLoading(String message);
}
