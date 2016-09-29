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
import com.cjt.employment.adapter.CollectionAdapter;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.CollectionPresenter;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends BaseActivity<CollectionActivity,CollectionPresenter> {
    private RecyclerView recyclerview_collection;
    private CollectionAdapter mCollectionAdapter;
    private List<String> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("收藏");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initData();
        initView();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            mDatas.add("Stirng " + i);
        }
    }

    private void initView() {
        recyclerview_collection= (RecyclerView) findViewById(R.id.recyclerview_collection);
        mCollectionAdapter=new CollectionAdapter(mDatas,this,null);
        recyclerview_collection.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerview_collection.setAdapter(mCollectionAdapter);
    }

    @Override
    protected CollectionPresenter creatPresenter() {
        return new CollectionPresenter();
    }
}
