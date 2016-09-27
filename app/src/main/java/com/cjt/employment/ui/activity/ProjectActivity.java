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
import com.cjt.employment.adapter.ProjectAdapter;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.Project;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.ProjectPresenter;
import com.cjt.employment.ui.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivity extends BaseActivity<ProjectActivity,ProjectPresenter> implements ProjectView {
    private RecyclerView recyclerview_project;
    private ProjectAdapter mProjectAdapter;
    private List<Project.DataBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("项目经历");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initData();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getProjectList("getProjectList", Config.getValueByKey(this,Config.KEY_USERID));
    }

    private void initData() {
        datas = new ArrayList<>();
    }
    private void initView() {
        recyclerview_project= (RecyclerView) findViewById(R.id.recyclerview_project);
        recyclerview_project.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mProjectAdapter=new ProjectAdapter(datas,this,null);
        recyclerview_project.setAdapter(mProjectAdapter);
    }

    @Override
    protected ProjectPresenter creatPresenter() {
        return new ProjectPresenter();
    }

    @Override
    public void getProjectSuccess(List<Project.DataBean> data) {
        mProjectAdapter.updata(data);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
