package com.mrq.library.FastScroll.viewprovider;

/**
 * Extending classes should use this interface to get notified about events that occur to the
 * fastscroller elements (handle and bubble) and react accordingly. See {@link DefaultBubbleBehavior}
 * for an example.
 */

/**
 * create by Ibrahim Mrq
 * 10/6/2021
 * */

public interface ViewBehavior {
    void onHandleGrabbed();
    void onHandleReleased();
    void onScrollStarted();
    void onScrollFinished();
}
