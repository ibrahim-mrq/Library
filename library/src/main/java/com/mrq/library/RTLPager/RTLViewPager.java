package com.mrq.library.RTLPager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.viewpager.widget.ViewPager;

public class RTLViewPager extends ViewPager {

    private boolean mIsRtlOriented;

    public RTLViewPager(Context context){
        this(context, null);
    }

    public RTLViewPager(Context context, AttributeSet attrs){
        super(context, attrs);
    }


    public void setRtlOriented(boolean isRtlOriented){
        mIsRtlOriented = isRtlOriented;
        if(mIsRtlOriented && getAdapter() != null){
            setCurrentItem(getAdapter().getCount() - 1);
        }else{
            setCurrentItem(0);
        }
    }

}
