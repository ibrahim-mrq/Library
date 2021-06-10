package com.mrq.library.RoundView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * create by Ibrahim Mrq
 * 10/6/2021
 * */

public class TabAdapter extends FragmentStatePagerAdapter {


    ArrayList<TabClass> tabs;

    public TabAdapter(FragmentManager fm, ArrayList<TabClass> tabs) {
        super(fm);
        this.tabs = tabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position).getFragment();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getName();

    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
