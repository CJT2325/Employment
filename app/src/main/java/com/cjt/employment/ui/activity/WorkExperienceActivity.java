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
import com.cjt.employment.adapter.WorkExperienceAdapter;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.WorkExperiencePresenter;
import com.cjt.employment.ui.view.WorkExperienceView;

import java.util.ArrayList;
import java.util.List;

public class WorkExperienceActivity extends BaseActivity<WorkExperienceActivity, WorkExperiencePresenter> implements WorkExperienceView {
    private RecyclerView recyclerview_workexperience;
    private WorkExperienceAdapter mWorkExperienceAdapter;
    private List<WorkExperience.DataBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_experience);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("工作经历");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initData();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getWorkExperienceList("getWorkExperienceList", Config.getValueByKey(this, Config.KEY_USERID));
    }

    @Override
    protected WorkExperiencePresenter creatPresenter() {
        return new WorkExperiencePresenter();
    }

    private void initData() {
        datas = new ArrayList<>();
    }

    private void initView() {
        recyclerview_workexperience = (RecyclerView) findViewById(R.id.recyclerview_workexperience);
        recyclerview_workexperience.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mWorkExperienceAdapter = new WorkExperienceAdapter(datas, this, null);
        recyclerview_workexperience.setAdapter(mWorkExperienceAdapter);
    }

    @Override
    public void getWorkExperienceSuccess(List<WorkExperience.DataBean> data) {
        mWorkExperienceAdapter.updata(data);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
