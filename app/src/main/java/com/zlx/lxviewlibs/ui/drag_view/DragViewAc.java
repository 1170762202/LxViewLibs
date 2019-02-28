package com.zlx.lxviewlibs.ui.drag_view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.zlx.lxviewlibs.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @date: 2019\2\26 0026
 * @author: zlx
 * @description: 模仿微信点击放大图片，拖拽缩回
 */
public class DragViewAc extends AppCompatActivity {
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;

    private ArrayList<String> list = new ArrayList<>();

    private List<ImageView> imgList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_drag_view);
        ButterKnife.bind(this);
        initViews();
    }


    protected void initViews() {
        ImmersionBar.with(this).transparentStatusBar().init();
        setSharedElementCallback(this);
        list.add("http://ww2.sinaimg.cn/large/6e00782dgw1etr3j0bmjeg20ca08848c.gif");
        list.add("http://69.171.66.103:8888/headImg/20190201/ea7f10bc7398596d475b1caa6f81099e.jpg");
        list.add("http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg");
        imgList.add(img1);
        imgList.add(img2);
        imgList.add(img3);
        for (int i = 0; i < imgList.size(); i++) {
            Glide.with(this).load(list.get(i)).into(imgList.get(i));
        }
    }


    private Bundle mReenterState;

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        mReenterState = new Bundle(data.getExtras());
    }


    /**
     * 接管Activity的setExitSharedElementCallback
     *
     * @param activity
     */
    public void setSharedElementCallback(Activity activity) {
        ActivityCompat.setExitSharedElementCallback(activity, new SharedElementCallback() {
            @Override
            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                if (mReenterState != null) {
                    int index = mReenterState.getInt("index", 0);
                    sharedElements.clear();
                    sharedElements.put("tansition_view", imgList.get(index));
                    mReenterState = null;
                }
            }
        });

    }


    @OnClick({R.id.img1, R.id.img2, R.id.img3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img1:
                PhotoBrowseAc.startWithElement(this, list, 0, img1);
                break;
            case R.id.img2:
                PhotoBrowseAc.startWithElement(this, list, 1, img1);
                break;
            case R.id.img3:
                PhotoBrowseAc.startWithElement(this, list, 2, img1);
                break;
        }
    }
}
