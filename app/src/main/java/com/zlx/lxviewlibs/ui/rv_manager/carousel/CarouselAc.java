package com.zlx.lxviewlibs.ui.rv_manager.carousel;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zlx.lxviewlibs.R;
import com.zlx.lxviewlibs.ui.rv_manager.carousel.listener.CarouselZoomPostLayoutListener;
import com.zlx.lxviewlibs.ui.rv_manager.carousel.listener.CenterScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @date: 2019\7\16 0016
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class CarouselAc extends AppCompatActivity {


    @BindView(R.id.rv_v)
    RecyclerView rvV;
    @BindView(R.id.rv_h)
    RecyclerView rvH;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_carousel);
        ButterKnife.bind(this);
        List<String> data = new ArrayList<>();
        data.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3925233323,1705701801&fm=27&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3389683750,3564498893&fm=27&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2022955630,4033585259&fm=27&gp=0.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1925692732,4159306238&fm=27&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=268042761,1199832267&fm=27&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3394263821,1263517319&fm=26&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=414401428,2343607491&fm=26&gp=0.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1396521707,1973816781&fm=26&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1923368568,3957327670&fm=26&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3925233323,1705701801&fm=27&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3389683750,3564498893&fm=27&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2022955630,4033585259&fm=27&gp=0.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1925692732,4159306238&fm=27&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=268042761,1199832267&fm=27&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3394263821,1263517319&fm=26&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=414401428,2343607491&fm=26&gp=0.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1396521707,1973816781&fm=26&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1923368568,3957327670&fm=26&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3925233323,1705701801&fm=27&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3389683750,3564498893&fm=27&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2022955630,4033585259&fm=27&gp=0.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1925692732,4159306238&fm=27&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=268042761,1199832267&fm=27&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3394263821,1263517319&fm=26&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=414401428,2343607491&fm=26&gp=0.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1396521707,1973816781&fm=26&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1923368568,3957327670&fm=26&gp=0.jpg");

        TestAdapter adapter = new TestAdapter(data);
        CarouselLayoutManager manager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL,true);
        manager.setMaxVisibleItems(5);
        manager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        rvV.setLayoutManager(manager);
        rvV.setHasFixedSize(true);
        rvV.setAdapter(adapter);
        rvV.addOnScrollListener(new CenterScrollListener());


        TestAdapter adapter1 = new TestAdapter(data);

        CarouselLayoutManager manager1 = new CarouselLayoutManager(CarouselLayoutManager.VERTICAL,true);
        manager1.setMaxVisibleItems(5);
        manager1.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        rvH.setLayoutManager(manager1);
        rvH.setHasFixedSize(true);
        rvH.setAdapter(adapter1);
        rvH.addOnScrollListener(new CenterScrollListener());

    }


    private static final class TestAdapter extends RecyclerView.Adapter<TestViewHolder> {

        @SuppressWarnings("UnsecureRandomNumberGeneration")

        private Context context;

        private List<String> data;

        public TestAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public TestViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
            context = parent.getContext();
            return new TestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_carousel, parent, false));
        }

        @Override
        public void onBindViewHolder(final TestViewHolder holder, final int position) {
            Log.e("TAG", "onBindViewHolder:" + position);
            Glide.with(context)
                    .load(data.get(position))
                    .into(holder.getImageView());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public long getItemId(final int position) {
            return position;
        }
    }

    private static class TestViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
}
