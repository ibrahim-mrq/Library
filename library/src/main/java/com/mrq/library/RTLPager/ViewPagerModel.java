package com.mrq.library.RTLPager;

import androidx.fragment.app.Fragment;

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
