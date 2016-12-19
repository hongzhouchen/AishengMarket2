package com.aisheng.aishengmarket.flyhand.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.aisheng.aishengmarket.R;
import com.aisheng.aishengmarket.flyhand.factory.HomeActFragfactory;

import static com.aisheng.aishengmarket.R.id.rg_buttom;

public class FS_HomeActivity extends AppCompatActivity {

    private FrameLayout fl_home;
    private  RadioGroup rg_buttom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fs_home);
        init();

    }
    private void init() {
        fl_home =(FrameLayout)findViewById(R.id.fl_home);
        rg_buttom = (RadioGroup)findViewById(R.id.rg_buttom);
        //默认第1个为选中
        rg_buttom.check(R.id.tab1);

        rg_buttom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 showFragment(checkedId);
            }
        });
    }

    private void showFragment(int checkedId) {
        Fragment fragment = HomeActFragfactory.getFragment(checkedId);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_home,fragment).commit();
    }


}
