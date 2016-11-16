package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.InformationDetialBean;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.presenter.InfomationDetailPresenter;
import com.cjt.employment.ui.view.InfomationDetailView;
import com.squareup.picasso.Picasso;

public class InfomationDetailActivity extends BaseActivity<InfomationDetailActivity,InfomationDetailPresenter> implements InfomationDetailView {
    private TextView tv_title;
    private TextView tv_time;
    private TextView tv_content;
    private ImageView iv_cover;
    private ProgressBar progressBar;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("正文");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        id = getIntent().getStringExtra("id");
        Log.i("CJT","++++++++++++++++++"+id);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getInfomationDetial("getInfomationDetial",id);
    }

    private void initView() {
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_time= (TextView) findViewById(R.id.tv_time);
        tv_content= (TextView) findViewById(R.id.tv_content);
        iv_cover= (ImageView) findViewById(R.id.iv_cover);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
    }

    @Override
    protected InfomationDetailPresenter creatPresenter() {
        return new InfomationDetailPresenter();
    }

    @Override
    public void updateInfomationDetial(InformationDetialBean.DataBean data) {
        tv_title.setText(data.getTitle());
        tv_content.setText(data.getContent());
        tv_time.setText(data.getTime());
        Picasso.with(this).load(ServerAPI.baseUrl + "image/infomationCover/" + data.getCover()).error(R.drawable.ic_person_black_24dp).into(iv_cover);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
