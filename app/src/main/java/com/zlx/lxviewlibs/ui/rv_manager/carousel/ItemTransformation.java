package com.zlx.lxviewlibs.ui.rv_manager.carousel;

/**
 * @date: 2019\7\16 0016
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class ItemTransformation {
    final float mScaleX;
    final float mScaleY;
    final float mTranslationX;
    final float mTranslationY;

    public ItemTransformation(final float scaleX, final float scaleY, final float translationX, final float translationY) {
        mScaleX = scaleX;
        mScaleY = scaleY;
        mTranslationX = translationX;
        mTranslationY = translationY;
    }
}
