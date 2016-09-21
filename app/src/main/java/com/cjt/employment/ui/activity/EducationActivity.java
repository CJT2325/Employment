package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cjt.employment.R;
import com.cjt.employment.adapter.EducationAdapter;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.EducationPresenter;
import com.cjt.employment.ui.view.EducationView;

import java.util.ArrayList;
import java.util.List;

public class EducationActivity extends BaseActivity<EducationActivity,EducationPresenter> implements EducationView {
    private RecyclerView recyclerview_education;
    private EducationAdapter mEducationAdapter;
    private List<Education.DataBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("教育经历");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initData();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getEducationList("getEducationList", Config.getValueByKey(this,Config.KEY_USERID));
    }

    @Override
    protected EducationPresenter creatPresenter() {
        return new EducationPresenter();
    }

    private void initData() {
        datas = new ArrayList<>();
    }

    private void initView() {
        recyclerview_education= (RecyclerView) findViewById(R.id.recyclerview_education);
        recyclerview_education.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mEducationAdapter=new EducationAdapter(datas,this,null);
        recyclerview_education.setAdapter(mEducationAdapter);
    }

    @Override
    public void getEducationSuccess(List<Education.DataBean> data) {
        mEducationAdapter.updata(data);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
