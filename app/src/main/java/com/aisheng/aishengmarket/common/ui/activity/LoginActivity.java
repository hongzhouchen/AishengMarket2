package com.aisheng.aishengmarket.common.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aisheng.aishengmarket.R;
import com.aisheng.aishengmarket.common.Application.MyApplication;
import com.aisheng.aishengmarket.common.constant.MyConstant;
import com.aisheng.aishengmarket.common.ui.utils.MyToast;
import com.aisheng.aishengmarket.common.utils.SPUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private RadioGroup rg_id;
    private RadioButton rb_fs;
    private RadioButton rb_nm;
    private CheckBox cb_remenber;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private EditText et_username;
    private EditText et_pwd;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
        iv_back = (ImageView) findViewById(R.id.iv_left);
        tv_title = (TextView) findViewById(R.id.tv_title);
        rg_id = (RadioGroup) findViewById(R.id.rg_id);
        rb_fs = (RadioButton) findViewById(R.id.rb_fs);
        rb_nm = (RadioButton) findViewById(R.id.rb_nm);
        et_username =(EditText)findViewById(R.id.et_username);
        et_pwd =(EditText)findViewById(R.id.et_pwd);
        btn_login =(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        rgCheckState(rg_id, R.id.rb_fs);//设置默认值
        RgGetRgState(rg_id);//点击事件
        /*记住密码，默认记住*/
        cb_remenber = (CheckBox) findViewById(R.id.cb_remenber);
        cb_remenber.setChecked(true);
        checked(true);

    }

    public void checked(boolean bool) {
            cb_remenber.setChecked(bool);

    }
    /**
     * 选择ID
     *
     * @param rg_id     RadioGroup
     * @param checkedId 选中 RadioButton 的ID
     */
    private void rgCheckState(RadioGroup rg_id, int checkedId) {
        rg_id.check(checkedId);//默认
        switch (checkedId) {
            case R.id.rb_fs:
                MyApplication.ID_Currunt = MyConstant.ID_FS;
                break;
            case R.id.rb_nm:
                MyApplication.ID_Currunt = MyConstant.ID_NM;
                break;
            default:
                MyApplication.ID_Currunt = MyConstant.ID_FS;
                break;
        }
    }

    /**
     * Rg的点击事件
     *
     * @param rg_id RadioGroup
     */
    private void RgGetRgState(RadioGroup rg_id) {
        rg_id.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_fs:
                        MyApplication.ID_Currunt = MyConstant.ID_FS;
                        break;
                    case R.id.rb_nm:
                        MyApplication.ID_Currunt = MyConstant.ID_NM;
                        break;
                    default:
                        MyApplication.ID_Currunt = MyConstant.ID_FS;
                        break;
                }
            }
        });


    }

    /**
     * 记住我
     *
     * @param username
     * @param password
     */
    private void remenberMe(String username, String password) {
        SPUtils.setFileName("LoginPassword");
        SPUtils.put(LoginActivity.this, "paaswrd", password);
        SPUtils.put(LoginActivity.this, "username", username);
    }

    private void login(){
        OkGo.post("http://www.baidu.com/").tag(this).params(new HttpParams("","")).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                 MyToast.showToast(LoginActivity.this,s);
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                MyToast.showToast(LoginActivity.this,response.toString());
            }
        });
    }

    private  Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String result=data.getString("json1");
            String userJson=data.getString("json2");
            MyToast.showToast(LoginActivity.this,userJson);
            MyToast.showToast(LoginActivity.this,result);
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.cb_remenber://记住密码
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }


}
