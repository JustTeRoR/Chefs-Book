package com.haerful.foodapp.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.haerful.foodapp.model.Category;
import com.haerful.foodapp.view.category.CategoryFragment;

import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    private List<Category> categories;

    public ViewPagerCategoryAdapter(FragmentManager fm, List<Category> categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int i) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString("EXTRA_DATA_NAME", categories.get(i).getEnglishname());
        args.putString("EXTRA_DATA_DESC", categories.get(i).getDescription());
        args.putString("EXTRA_DATA_IMAGE", categories.get(i).getImageurl());
        args.putString("EXTRA_DATA_RUSSIAN_NAME", categories.get(i).getName());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getName();
    }
}
