package com.mrq.library.FastScroll.viewprovider;

/**
 * create by Ibrahim Mrq
 * 10/June/2021
 * */

public interface ViewBehavior {
    void onHandleGrabbed();
    void onHandleReleased();
    void onScrollStarted();
    void onScrollFinished();
}
