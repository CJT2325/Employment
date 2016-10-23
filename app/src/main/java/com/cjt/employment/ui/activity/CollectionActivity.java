package com.cjt.employment.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.adapter.CollectionAdapter;
import com.cjt.employment.bean.CollectionBean;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.CollectionPresenter;
import com.cjt.employment.ui.view.CollectionView;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends BaseActivity<CollectionActivity, CollectionPresenter> implements CollectionView {
    private RecyclerView recyclerview_collection;
    private CollectionAdapter mCollectionAdapter;
    private List<CollectionBean.DataBean> mDatas;
    private ProgressBar progressBar;

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

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getCollection("getCollection", Config.getValueByKey(this, Config.KEY_USERID));
    }

    private void initData() {
        mDatas = new ArrayList<CollectionBean.DataBean>();
    }

    private void initView() {
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        recyclerview_collection = (RecyclerView) findViewById(R.id.recyclerview_collection);
        mCollectionAdapter = new CollectionAdapter(mDatas, this, this, new CollectionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mCollectionAdapter.startActivityByRecruitId(position);
            }
        });
        recyclerview_collection.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerview_collection.setAdapter(mCollectionAdapter);
    }

    @Override
    protected CollectionPresenter creatPresenter() {
        return new CollectionPresenter();
    }

    @Override
    public void getCollectionSuccess(List<CollectionBean.DataBean> data) {
        mCollectionAdapter.updata(data);
    }

    @Override
    public void getCollectionFail() {

    }

    @Override
    public void deleteSuccess() {
        getPresenter().getCollection("getCollection", Config.getValueByKey(this, Config.KEY_USERID));
    }

    @Override
    public void deleteFail() {

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void deleteCollection(int id) {
        getPresenter().deleteCollectionById("deleteCollection", Config.getValueByKey(this, Config.KEY_USERID), id + "");
    }

    @Override
    public void sendVitage(final int id, final int companyid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确认投递简历？")
                .setPositiveButton("取消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().sendVitage("pushVitage", Config.getValueByKey(CollectionActivity.this, Config.KEY_USERID), id, companyid);
                    }
                }).show();

    }

    @Override
    public void sendVitageSuccess() {
        Toast.makeText(this, "投递简历成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendVitageFail() {
        Toast.makeText(this, "投递简历失败", Toast.LENGTH_SHORT).show();
    }
}
