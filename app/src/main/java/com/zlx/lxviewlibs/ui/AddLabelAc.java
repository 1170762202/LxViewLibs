package com.zlx.lxviewlibs.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhy.view.flowlayout.TagFlowLayout;
import com.zlx.lxviewlibs.R;

/**
 * @date: 2019\3\21 0021
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class AddLabelAc extends AppCompatActivity {

    private TagFlowLayout tagFlowLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_add_label);
        tagFlowLayout = findViewById(R.id.flow_layout);

    }
}
