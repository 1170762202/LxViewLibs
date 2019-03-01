package com.zlx.lxviewlibs.ui.drag_view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.zlx.lxviewlibs.R;

import net.moyokoo.diooto.Diooto;
import net.moyokoo.diooto.config.DiootoConfig;
import net.moyokoo.diooto.interfaces.DefaultCircleProgress;

import org.salient.artplayer.MediaPlayerManager;
import org.salient.artplayer.ScaleType;
import org.salient.artplayer.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.panpf.sketch.SketchImageView;

/**
 * @date: 2019\2\28 0028
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class DragViewListAc extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private Context context;

    String[] longImageUrl = new String[]{
            "https://ww4.sinaimg.cn/bmiddle/61e7945bly1fwnpjo7er0j215o6u77o1.jpg",
            "http://wx3.sinaimg.cn/large/9f780829ly1fwvwhq9cg3j2cn40e2npj.jpg",
            "https://wx2.sinaimg.cn/mw600/6d239c49ly1fwsvs7rtocj20k3cmpkjs.jpg",
            "https://wx1.sinaimg.cn/mw600/71038334gy1fwv2i5084aj20b42wigqi.jpg",
            "https://wx3.sinaimg.cn/large/8378206bly1fvf2j96kryj20dc7uhkjq.jpg",
            "https://wx4.sinaimg.cn/large/0075aoetgy1fwkmjmcl67j30b3cmchdw.jpg",
            "https://wx1.sinaimg.cn/mw600/71038334gy1fwv2i5084aj20b42wigqi.jpg",
            "https://wx3.sinaimg.cn/large/8378206bly1fvf2j96kryj20dc7uhkjq.jpg",
            "https://wx4.sinaimg.cn/large/0075aoetgy1fwkmjmcl67j30b3cmchdw.jpg"
    };
    String[] normalImageUlr = new String[]{
            "http://img1.juimg.com/140908/330608-140ZP1531651.jpg",
            "https://github.com/moyokoo/Media/blob/master/diooto2.jpg?raw=true",
            "https://github.com/moyokoo/Media/blob/master/diooto3.jpg?raw=true",
            "https://github.com/moyokoo/Media/blob/master/diooto4.jpg?raw=true",
            "https://github.com/moyokoo/Media/blob/master/diooto5.jpg?raw=true",
            "https://github.com/moyokoo/Media/blob/master/diooto6.jpg?raw=true",
            "https://github.com/moyokoo/Media/blob/master/diooto7.png?raw=true",
            "https://github.com/moyokoo/Media/blob/master/diooto8.png?raw=true",
            "https://github.com/moyokoo/Media/blob/master/diooto9.jpg?raw=true"
    };

    boolean isImmersive = true;
    int activityPosition;

    public static void start(Activity activity, int position) {
        Intent intent = new Intent(activity, DragViewListAc.class);
        intent.putExtra("position", position);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_drag_view_list);
        ImmersionBar.with(this).init();

        ButterKnife.bind(this);
        context = this;

        activityPosition = getIntent().getIntExtra("position", 0);
        Log.e("TAG", "activityPosition:" + activityPosition);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(new MainAdapter());
    }


    class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(
                    context).inflate(R.layout.item_grid, parent,
                    false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            boolean isLong = activityPosition == TypeEnum.listLong.getType();
            holder.srcImageView.displayImage(isLong ? longImageUrl[position] : normalImageUlr[position]);
            holder.srcImageView.setShowGifFlagEnabled(R.drawable.ic_gif);
            holder.srcImageView.setOnClickListener(srcView -> {
                if (activityPosition == TypeEnum.listVideo.getType()) {
                    //加载视频
                    Diooto diooto = new Diooto(context)
                            .urls(normalImageUlr[position])
                            .position(holder.getAdapterPosition())
                            .views(holder.srcImageView)
                            .type(DiootoConfig.VIDEO)
                            .immersive(isImmersive)
                            .setProgress(new DefaultCircleProgress())
                            //提供视频View
                            .onProvideVideoView(() -> new VideoView(context))
                            //显示视频加载之前的缩略图
                            .loadPhotoBeforeShowBigImage((sketchImageView, position13) -> sketchImageView.displayImage(normalImageUlr[position]))
                            //动画到最大化时的接口
                            .onVideoLoadEnd((dragDiootoView, sketchImageView, progressView) -> {
                                VideoView videoView = (VideoView) dragDiootoView.getContentView();
                                SimpleControlPanel simpleControlPanel = new SimpleControlPanel(context);
                                simpleControlPanel.setOnClickListener(v -> dragDiootoView.backToMin());
                                simpleControlPanel.setOnVideoPreparedListener(() -> {
                                    sketchImageView.setVisibility(View.GONE);
                                    progressView.setVisibility(View.GONE);
                                });
                                videoView.setControlPanel(simpleControlPanel);
                                videoView.setUp("http://bmob-cdn-982.b0.upaiyun.com/2017/02/23/266454624066f2b680707492a0664a97.mp4");
                                videoView.start();
                                dragDiootoView.notifySize(1920, 1080);
                                MediaPlayerManager.instance().setScreenScale(ScaleType.SCALE_CENTER_CROP);
                            })
                            //到最小状态的接口
                            .onFinish(dragDiootoView -> MediaPlayerManager.instance().releasePlayerAndView(context))
                            .start();
                } else if (activityPosition == TypeEnum.singleNormal.getType()) {
                    //加载单张图片
                    Diooto diooto = new Diooto(context)
                            .urls(normalImageUlr[position])
                            .type(DiootoConfig.PHOTO)
                            .immersive(isImmersive)
                            .position(0)
                            .views(holder.srcImageView)
                            .loadPhotoBeforeShowBigImage((sketchImageView, position1) -> {
                                sketchImageView.displayImage(normalImageUlr[position]);
                            })
                            .start();
                } else {
                    String[] strings = isLong ? longImageUrl : normalImageUlr;
                    Diooto diooto = new Diooto(context)
                            .urls(strings)
                            .type(DiootoConfig.PHOTO)
                            .immersive(isImmersive)
                            .position(holder.getAdapterPosition(), 0)
                            .views(mRecyclerView, R.id.srcImageView)
                            .loadPhotoBeforeShowBigImage((sketchImageView, position12) -> {
                                Log.e("TAG", "loadPhotoBeforeShowBigImage:" + position12);
//                                Glide.with(context).load(normalImageUlr[position]).into(sketchImageView);
//                                sketchImageView.displayImage(normalImageUlr[position]);
                                sketchImageView.setOnLongClickListener(v -> {
                                    Toast.makeText(context, "Long click", Toast.LENGTH_SHORT).show();
                                    return false;
                                });
                            })
                            .start();
                }
            });
        }

        @Override
        public int getItemCount() {
            return normalImageUlr.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            SketchImageView srcImageView;

            public MyViewHolder(View view) {
                super(view);
                srcImageView = view.findViewById(R.id.srcImageView);
            }
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerManager.instance().pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayerManager.instance().releasePlayerAndView(this);
    }
}
