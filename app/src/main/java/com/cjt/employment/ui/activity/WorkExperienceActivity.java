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

import java.util.ArrayList;
import java.util.List;

public class WorkExperienceActivity extends AppCompatActivity {
    private RecyclerView recyclerview_workexperience;
    private WorkExperienceAdapter mWorkExperienceAdapter;
    private List<String> datas;

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

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("String " + i);
        }
    }

    private void initView() {
        recyclerview_workexperience = (RecyclerView) findViewById(R.id.recyclerview_workexperience);
        recyclerview_workexperience.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mWorkExperienceAdapter = new WorkExperienceAdapter(datas, this, null);
        recyclerview_workexperience.setAdapter(mWorkExperienceAdapter);
    }
}
