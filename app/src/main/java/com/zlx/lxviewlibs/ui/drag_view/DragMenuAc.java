package com.zlx.lxviewlibs.ui.drag_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zlx.lxviewlibs.R;

/**
 * @date: 2019\2\28 0028
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class DragMenuAc extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_drag_menu);
    }

    public void style1(View view) {
        startActivity(new Intent(this,DragViewAc.class));
    }

    public void style2_1(View view) {
        DragViewListAc.start(this,TypeEnum.singleNormal.getType());
    }
    public void style2_2(View view) {
        DragViewListAc.start(this,TypeEnum.listLong.getType());

    }
    public void style2_3(View view) {
        DragViewListAc.start(this,TypeEnum.listNormal.getType());

    }
    public void style2_4(View view) {
        DragViewListAc.start(this,TypeEnum.listVideo.getType());

    }

}
