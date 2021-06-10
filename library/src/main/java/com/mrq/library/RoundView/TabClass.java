package com.mrq.library.RoundView;

import androidx.fragment.app.Fragment;

/**
 * create by Ibrahim Mrq
 * 10/6/2021
 * */

public class TabClass {
    private String name;
    private Fragment fragment;

    public TabClass(String name, Fragment fragment) {
        this.name = name;
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
