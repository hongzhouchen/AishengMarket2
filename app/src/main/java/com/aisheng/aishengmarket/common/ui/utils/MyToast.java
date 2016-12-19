package com.aisheng.aishengmarket.common.ui.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by chz1992 on 2016/11/29.
 */

public class MyToast {
    public static void showToast(Context context, String msg){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

}
