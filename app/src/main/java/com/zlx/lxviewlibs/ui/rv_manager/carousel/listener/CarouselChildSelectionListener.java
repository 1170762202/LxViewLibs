package com.zlx.lxviewlibs.ui.rv_manager.carousel.listener;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zlx.lxviewlibs.ui.rv_manager.carousel.CarouselLayoutManager;

/**
 * @date: 2019\7\16 0016
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public abstract class CarouselChildSelectionListener {
    @NonNull
    private final RecyclerView mRecyclerView;
    @NonNull
    private final CarouselLayoutManager mCarouselLayoutManager;

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            final RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
            final int position = holder.getAdapterPosition();

            if (position == mCarouselLayoutManager.getCenterItemPosition()) {
                onCenterItemClicked(mRecyclerView, mCarouselLayoutManager, v);
            } else {
                onBackItemClicked(mRecyclerView, mCarouselLayoutManager, v);
            }
        }
    };

    protected CarouselChildSelectionListener(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager) {
        mRecyclerView = recyclerView;
        mCarouselLayoutManager = carouselLayoutManager;

        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(final View view) {
                view.setOnClickListener(mOnClickListener);
            }

            @Override
            public void onChildViewDetachedFromWindow(final View view) {
                view.setOnClickListener(null);
            }
        });
    }

    protected abstract void onCenterItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v);

    protected abstract void onBackItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v);
}