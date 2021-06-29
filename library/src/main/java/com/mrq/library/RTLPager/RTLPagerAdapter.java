package com.mrq.library.RTLPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * create by Ibrahim Mrq
 * 10/June/2021
 * */

public class RTLPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<ViewPagerModel> list;
    private boolean mIsRtlOrientated = false;

    public RTLPagerAdapter(@NonNull FragmentManager fm, ArrayList<ViewPagerModel> list) {
        super(fm);
        this.list = list;
    }

    public RTLPagerAdapter(@NonNull FragmentManager fm, ArrayList<ViewPagerModel> list, boolean isRtlOriented) {
        super(fm);
        this.list = list;
        mIsRtlOrientated = isRtlOriented;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mIsRtlOrientated && list != null && list.size() > 0) {
            return list.get(position - position - 1).getFragment().getText(position);
        } else {
            return list.get(position).getFragment().getText(position);
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (mIsRtlOrientated && list != null && list.size() > 0) {
            return list.get(list.size() - position - 1).getFragment();
        } else {
            return list.get(position).getFragment();
        }
    }
}
