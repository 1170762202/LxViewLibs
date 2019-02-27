package com.zlx.lxviewlibs.ui.combine_view;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.zlx.lxviewlibs.R;
import com.zlx.lxviewlibs.ui.combine_view.widget.CombineView;
import com.zlx.lxviewlibs.ui.combine_view.widget.NiceImageView;
import com.zlx.lxviewlibs.ui.combine_view.widget.layout.DingLayoutManager;
import com.zlx.lxviewlibs.ui.combine_view.widget.layout.WechatLayoutManager;
import com.zlx.lxviewlibs.ui.combine_view.widget.listener.OnProgressListener;
import com.zlx.lxviewlibs.ui.combine_view.widget.listener.OnSubItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @date: 2019\2\27 0027
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class CombineAc extends AppCompatActivity {
    @BindView(R.id.nice_iv1)
    NiceImageView niceIv1;
    @BindView(R.id.nice_iv2)
    NiceImageView niceIv2;
    @BindView(R.id.nice_iv3)
    NiceImageView niceIv3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.iv5)
    ImageView iv5;
    @BindView(R.id.iv6)
    ImageView iv6;
    @BindView(R.id.iv7)
    ImageView iv7;
    @BindView(R.id.iv8)
    ImageView iv8;
    @BindView(R.id.iv9)
    ImageView iv9;
    @BindView(R.id.iv10)
    ImageView iv10;
    @BindView(R.id.iv11)
    ImageView iv11;

    private String[] IMG_URL_ARR = {
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4015008175,1109648284&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4250975285,3972264058&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3957536318,2449211767&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3370442833,4268965594&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3914188161,7447113&fm=27&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4259300811,497831842&fm=27&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3243445518,1285394533&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4118792058,1226806534&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2515071376,1278574704&fm=27&gp=0.jpg",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combine_ac);
        ButterKnife.bind(this);
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(perms, 1000);
        }else {
            load();
        }
    }

    private void load(){
        loadDingBitmap(niceIv1, 2);

        loadDingBitmap(niceIv2, 3);

        loadDingBitmap(niceIv3, 4);

        loadWechatBitmap(iv4, 2);

        loadWechatBitmap(iv5, 3);

        loadWechatBitmap(iv6, 4);

        loadWechatBitmap(iv7, 5);

        loadWechatBitmap(iv8, 6);

        loadWechatBitmap(iv9, 7);

        loadWechatBitmap(iv10, 8);

        loadWechatBitmap(iv11, 9);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000 && grantResults.length > 0) {
            load();
        }
    }


    private void loadWechatBitmap(ImageView imageView, int count) {
        CombineView.init(this)
                .setLayoutManager(new WechatLayoutManager())
                .setSize(180)
                .setGap(3)
                .setGapColor(Color.parseColor("#E8E8E8"))
                .setUrls(getUrls(count))
                .setImageView(imageView)
                .setOnSubItemClickListener(new OnSubItemClickListener() {
                    @Override
                    public void onSubItemClick(int index) {
                        Log.e("SubItemIndex", "--->" + index);
                    }
                })
                .build();
    }

    private String[] getUrls(int count) {
        String[] urls = new String[count];
        System.arraycopy(IMG_URL_ARR, 0, urls, 0, count);
        return urls;
    }

    private void loadDingBitmap(final ImageView imageView, int count) {
        CombineView.init(this)
                .setLayoutManager(new DingLayoutManager())
                .setSize(180)
                .setGap(2)
                .setUrls(getUrls(count))
                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onComplete(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                })
                .build();
    }
}
