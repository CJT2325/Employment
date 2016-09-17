package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.presenter.VitagePresenter;

public class VitaeActivity extends BaseActivity<VitaeActivity, VitagePresenter> implements View.OnClickListener {

    private RelativeLayout layout_user_unedit;
    private RelativeLayout layout_user_edit;

    private TextView tv_name;
    private TextView tv_sex;
    private TextView tv_brithday;
    private TextView tv_education;
    private TextView tv_worktime;
    private TextView tv_phone;
    private TextView tv_email;
    private TextView tv_city;

    public final static int requestCode = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitae);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {
        tv_name= (TextView) findViewById(R.id.tv_name);
        tv_sex= (TextView) findViewById(R.id.tv_sex);
        tv_brithday= (TextView) findViewById(R.id.tv_brithday);
        tv_education= (TextView) findViewById(R.id.tv_education);
        tv_worktime= (TextView) findViewById(R.id.tv_worktime);
        tv_phone= (TextView) findViewById(R.id.tv_phone);
        tv_email= (TextView) findViewById(R.id.tv_email);
        tv_city= (TextView) findViewById(R.id.tv_city);

        layout_user_unedit = (RelativeLayout) findViewById(R.id.layout_user_unedit);
        layout_user_edit = (RelativeLayout) findViewById(R.id.layout_user_edit);
        layout_user_unedit.setOnClickListener(this);
        layout_user_edit.setOnClickListener(this);
        layout_user_unedit.setVisibility(View.VISIBLE);
        layout_user_edit.setVisibility(View.GONE);
    }

    @Override
    protected VitagePresenter creatPresenter() {
        return new VitagePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_user_unedit:
                Intent editIntent = new Intent(this, VitageUserEditActivity.class);
                startActivityForResult(editIntent, requestCode);
                break;
            case R.id.layout_user_edit:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VitaeActivity.requestCode && resultCode == 1) {
            layout_user_unedit.setVisibility(View.GONE);
            layout_user_edit.setVisibility(View.VISIBLE);
            tv_name.setText("姓        名:  "+data.getStringExtra("name"));
            tv_sex.setText("性        别:  "+data.getStringExtra("sex"));
            tv_brithday.setText("出生年份:  "+data.getStringExtra("brithday"));
            tv_education.setText("最高学历:  "+data.getStringExtra("education"));
            tv_worktime.setText("工作年限:  "+data.getStringExtra("worktime"));
            tv_phone.setText("联系电话:  "+data.getStringExtra("phone"));
            tv_email.setText("联系邮箱:  "+data.getStringExtra("email"));
            tv_city.setText("所在城市:  "+data.getStringExtra("city"));
        }
    }
}
