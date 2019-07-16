package com.zlx.lxviewlibs.ui.rv_manager.carousel.listener;

import android.support.v7.widget.RecyclerView;

import com.zlx.lxviewlibs.ui.rv_manager.carousel.CarouselLayoutManager;

/**
 * @date: 2019\7\16 0016
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class CenterScrollListener extends RecyclerView.OnScrollListener {

    private boolean mAutoSet = true;

    @Override
    public void onScrollStateChanged(final RecyclerView recyclerView, final int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof CarouselLayoutManager)) {
            mAutoSet = true;
            return;
        }

        final CarouselLayoutManager lm = (CarouselLayoutManager) layoutManager;
        if (!mAutoSet) {
            if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                final int scrollNeeded = lm.getOffsetCenterView();
                if (CarouselLayoutManager.HORIZONTAL == lm.getOrientation()) {
                    recyclerView.smoothScrollBy(scrollNeeded, 0);
                } else {
                    recyclerView.smoothScrollBy(0, scrollNeeded);
                }
                mAutoSet = true;
            }
        }
        if (RecyclerView.SCROLL_STATE_DRAGGING == newState || RecyclerView.SCROLL_STATE_SETTLING == newState) {
            mAutoSet = false;
        }
    }
}
