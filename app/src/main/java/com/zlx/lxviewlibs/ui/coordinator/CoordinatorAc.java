package com.zlx.lxviewlibs.ui.coordinator;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zlx.lxviewlibs.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @date: 2019\2\28 0028
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class CoordinatorAc extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;

    private List<String> list = new ArrayList<>();

    private VpAdapter adapter;
    private Context context;
    private ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_coordinator);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        context = this;
        list.add("tab1");
        list.add("tab2");
        list.add("tab3");
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("tab" + i);
        }

        adapter = new VpAdapter();
        vp.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(vp);
        for (int i = 0; i < list.size(); i++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i);
            if (tabAt != null) {
                tabAt.setText(list.get(i));
            }
        }
    }


    class VpAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View body = LayoutInflater.from(context).inflate(R.layout.coordinator_item, null);
            RecyclerView recyclerView = body.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            RvAdpater adpater = new RvAdpater();
            recyclerView.setAdapter(adpater);
            container.addView(body);
            return body;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    class RvAdpater extends RecyclerView.Adapter<RvAdpater.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View body = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            return new ViewHolder(body);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.text1.setText(data.get(i));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView text1;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text1 = itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
