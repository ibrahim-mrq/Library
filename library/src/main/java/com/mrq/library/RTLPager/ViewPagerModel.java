package com.mrq.library.RTLPager;

import androidx.fragment.app.Fragment;

/**
 * create by Ibrahim Mrq
 * 10/6/2021
 * */

public class ViewPagerModel {

    private Fragment fragment ;

    public ViewPagerModel(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }


}
