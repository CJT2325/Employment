package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.adapter.AdapterForLinearLayout;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.VitagePresenter;
import com.cjt.employment.ui.view.VitageView;
import com.cjt.employment.view.LinearLayoutForListView;

import java.util.ArrayList;
import java.util.HashMap;

public class VitaeActivity extends BaseActivity<VitaeActivity, VitagePresenter> implements View.OnClickListener, VitageView {

    private RelativeLayout layout_user_unedit;
    private RelativeLayout layout_user_edit;

    private LinearLayoutForListView worklistview;
    private AdapterForLinearLayout worklistviewAdpater;

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
        getPresenter().getVitageUser("getVitageUser", Config.getValueByKey(this, Config.KEY_USERID));
    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_brithday = (TextView) findViewById(R.id.tv_brithday);
        tv_education = (TextView) findViewById(R.id.tv_education);
        tv_worktime = (TextView) findViewById(R.id.tv_worktime);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_city = (TextView) findViewById(R.id.tv_city);

        layout_user_unedit = (RelativeLayout) findViewById(R.id.layout_user_unedit);
        layout_user_edit = (RelativeLayout) findViewById(R.id.layout_user_edit);
        layout_user_unedit.setOnClickListener(this);
        layout_user_edit.setOnClickListener(this);
        layout_user_unedit.setVisibility(View.VISIBLE);
        layout_user_edit.setVisibility(View.GONE);

        worklistview= (LinearLayoutForListView) findViewById(R.id.layout_worklistview);
        getData();
    }

    private void getData() {

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> win = new HashMap<String, Object>();
            win.put("thread_number", "2016.09-2016.10");
            win.put("thread_author", "某某科技有限公司/Android");
            win.put("thread_time", "工作内容: 工作内容工作内容工作内容工作内容工作内容工作内容");
            list.add(win);
        }

        worklistviewAdpater = new AdapterForLinearLayout(this, list,R.layout.worklist_item, new String[] { "thread_number", "thread_author" ,"thread_time"},
                new int[] { R.id.tv_worktime, R.id.tv_workname,R.id.tv_workcontent});
        worklistview.setAdapter(worklistviewAdpater);

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
            tv_name.setText("姓        名:  " + data.getStringExtra("name"));
            tv_sex.setText("性        别:  " + data.getStringExtra("sex"));
            tv_brithday.setText("出生年份:  " + data.getStringExtra("brithday"));
            tv_education.setText("最高学历:  " + data.getStringExtra("education"));
            tv_worktime.setText("工作年限:  " + data.getStringExtra("worktime"));
            tv_phone.setText("联系电话:  " + data.getStringExtra("phone"));
            tv_email.setText("联系邮箱:  " + data.getStringExtra("email"));
            tv_city.setText("所在城市:  " + data.getStringExtra("city"));
        }
    }

    @Override
    public void getVitageSuccess(VitageBean.DataBean data) {
        layout_user_unedit.setVisibility(View.GONE);
        layout_user_edit.setVisibility(View.VISIBLE);
        tv_name.setText("姓        名:  " + data.getName());
        tv_sex.setText("性        别:  " + data.getSex());
        tv_brithday.setText("出生年份:  " + data.getBrithday());
        tv_education.setText("最高学历:  " + data.getEducation());
        tv_worktime.setText("工作年限:  " + data.getWorktime());
        tv_phone.setText("联系电话:  " + data.getPhone());
        tv_email.setText("联系邮箱:  " + data.getEmail());
        tv_city.setText("所在城市:  " + data.getCity());
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
