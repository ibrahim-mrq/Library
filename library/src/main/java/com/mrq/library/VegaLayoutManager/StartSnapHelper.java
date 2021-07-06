package com.mrq.library.VegaLayoutManager;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * create by Ibrahim Mrq
 * 10/June/2021
 */

public class StartSnapHelper extends LinearSnapHelper {

    @Override
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager,
                                              @NonNull View targetView) {
        int[] out = new int[2];
        out[0] = 0;
        out[1] = ((VegaLayoutManager) layoutManager).getSnapHeight();
        return out;
    }

    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        VegaLayoutManager custLayoutManager = (VegaLayoutManager) layoutManager;
        return custLayoutManager.findSnapView();
    }
}