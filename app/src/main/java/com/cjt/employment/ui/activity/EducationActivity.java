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

import java.util.ArrayList;
import java.util.List;

public class EducationActivity extends AppCompatActivity {
    private RecyclerView recyclerview_education;
    private EducationAdapter mEducationAdapter;
    private List<String> datas;

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

    private void initData() {
        datas = new ArrayList<>();
        datas.add("1123");
    }

    private void initView() {
        recyclerview_education= (RecyclerView) findViewById(R.id.recyclerview_education);
        recyclerview_education.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mEducationAdapter=new EducationAdapter(datas,this,null);
        recyclerview_education.setAdapter(mEducationAdapter);
    }
}
