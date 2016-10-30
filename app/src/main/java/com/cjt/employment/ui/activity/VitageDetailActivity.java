package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.VitageDetailBean;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.presenter.VitageDetailPresenter;
import com.cjt.employment.ui.view.VitageDetailView;
import com.squareup.picasso.Picasso;

public class VitageDetailActivity extends BaseActivity<VitageDetailActivity, VitageDetailPresenter> implements View.OnClickListener, VitageDetailView {
    private ProgressBar progressBar;
    private TextView tv_time;
    private TextView tv_result;
    private TextView tv_state;

    private ImageView iv_cover;
    private TextView tv_position;
    private TextView tv_company;
    private TextView tv_wage;
    private TextView tv_date;
    private TextView tv_recruitinfo;
    private TextView tv_companyinfo;

    private RelativeLayout layout_recruitment;

    private String id = "";
    private int recruitID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitage_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("投递记录");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        id = getIntent().getStringExtra("id");
        initView();
        getPresenter().getVitageDetail("getVitageDetail", id);
    }

    private void initView() {
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        tv_state = (TextView) findViewById(R.id.tv_state);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_time = (TextView) findViewById(R.id.tv_time);
        layout_recruitment = (RelativeLayout) findViewById(R.id.layout_recruitment);
        layout_recruitment.setOnClickListener(this);

        iv_cover = (ImageView) findViewById(R.id.iv_cover);
        tv_position = (TextView) findViewById(R.id.tv_position);
        tv_company = (TextView) findViewById(R.id.tv_company);
        tv_wage = (TextView) findViewById(R.id.tv_wage);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_recruitinfo = (TextView) findViewById(R.id.tv_recruitinfo);
        tv_companyinfo = (TextView) findViewById(R.id.tv_companyinfo);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected VitageDetailPresenter creatPresenter() {
        return new VitageDetailPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_recruitment:
                Intent recruitmentInfoIntent = new Intent(this, RecruitmentInfoActivity.class);
                recruitmentInfoIntent.putExtra("id", recruitID);
                startActivity(recruitmentInfoIntent);
                break;
        }
    }

    @Override
    public void getVitageDetailSuccess(VitageDetailBean.DataBean dataBean) {
        recruitID=dataBean.getRecruitid();

        Picasso.with(this).load(ServerAPI.baseUrl + "image/companyCover/" + dataBean.getLogo()).into(iv_cover);
        tv_position.setText(dataBean.getPosition());
        tv_company.setText(dataBean.getCompany());
        tv_date.setText(dataBean.getReleasedate());
        int wagestart = dataBean.getWagesstart() / 1000;
        int wageend = dataBean.getWagesend() / 1000;
        String wage = wagestart + "-" + wageend + "k";
        tv_wage.setText(wage);
        tv_recruitinfo.setText(dataBean.getWorkplace() + " " + dataBean.getWorkingyearstart() + "-" + dataBean.getWorkingyearend() + "年" + " " + dataBean.getEducation());
        tv_companyinfo.setText(dataBean.getFinancing() + " | " + dataBean.getEmployenumber() + "人 | " + dataBean.getPattern());

        tv_time.setText("投递时间：" + dataBean.getTime());
        //0:未处理 1被查看 2呆面试 3不合适
        switch (dataBean.getState()) {
            case 0:
                tv_state.setText("投递结果：未处理");
                tv_result.setText("你的简历还未被处理，请耐心等候...");
                break;
            case 1:
                tv_state.setText("投递结果：被查看");
                tv_result.setText("你的简历已被查看，请耐心等候...");
                break;
            case 2:
                tv_state.setText("投递结果：待面试");
                tv_result.setText(dataBean.getResult());
                break;
            case 3:
                tv_state.setText("投递结果：不合适");
                tv_result.setText(dataBean.getResult());
                break;
        }
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
