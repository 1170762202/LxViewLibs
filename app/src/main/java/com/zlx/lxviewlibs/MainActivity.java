package com.zlx.lxviewlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.zlx.lxviewlibs.ui.circle_image_view.CircleImgAc;
import com.zlx.lxviewlibs.ui.combine_view.CombineAc;
import com.zlx.lxviewlibs.ui.coordinator.CoordinatorAc;
import com.zlx.lxviewlibs.ui.drag_view.DragMenuAc;
import com.zlx.lxviewlibs.ui.drag_view.DragViewAc;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    private List<String> list = Arrays.asList("模仿微信拖拽放大缩小图片", "群聊头像组合","coordinator","圆形头像");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        listView = findViewById(R.id.list_view);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                open(DragMenuAc.class);
                break;
            case 1:
                open(CombineAc.class);
                break;
            case 2:
                open(CoordinatorAc.class);
                break;
            case 3:
                open(CircleImgAc.class);
                break;
        }
    }

    private void open(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
