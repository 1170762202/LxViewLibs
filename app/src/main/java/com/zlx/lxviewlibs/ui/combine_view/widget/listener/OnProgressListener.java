package com.zlx.lxviewlibs.ui.combine_view.widget.listener;

import android.graphics.Bitmap;

public interface OnProgressListener {
    void onStart();

    void onComplete(Bitmap bitmap);
}
