package com.aisheng.aishengmarket.flyhand.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aisheng.aishengmarket.R;

/**
 * Created by chz1992 on 2016/12/19.
 */

public class IndexFragment extends Fragment {


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
        View view = inflater.inflate(R.layout.fragment_fs_index, null);
        return view;
    }
}
