package com.aisheng.aishengmarket.flyhand.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chz1992 on 2016/12/19.
 */

public class OrderFragment extends Fragment {

    private Context mContex;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContex=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv= new TextView(mContex);
        tv.setText("订单");
        return tv;
    }
}
