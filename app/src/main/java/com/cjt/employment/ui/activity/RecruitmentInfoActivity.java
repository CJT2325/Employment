package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.presenter.BasePresenter;
import com.cjt.employment.presenter.RecruitmentInfoPresenter;
import com.cjt.employment.ui.view.RecruitmentInfoView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class RecruitmentInfoActivity extends BaseActivity<RecruitmentInfoActivity, RecruitmentInfoPresenter> implements View.OnClickListener, RecruitmentInfoView {
    private RelativeLayout layout_companyinfo;
    private int recruitId;

    private TextView tv_position;
    private TextView tv_wage;
    private TextView tv_workspace;
    private TextView tv_workyear;
    private TextView tv_education;
    private TextView tv_company;
    private TextView tv_companyinfo;
    private TextView tv_founder;
    private ImageView iv_cover;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("职位详情");
        setSupportActionBar(toolbar);
        initView();
        recruitId = getIntent().getIntExtra("id", 0);
        Log.i("CJT", recruitId + " ");
        getPresenter().getRecruitInfoById("getRecruitInfoById", recruitId);
        showProgressBar();
    }

    @Override
    protected RecruitmentInfoPresenter creatPresenter() {
        return new RecruitmentInfoPresenter();
    }


    private void initView() {
        layout_companyinfo = (RelativeLayout) findViewById(R.id.layout_companyinfo);
        layout_companyinfo.setOnClickListener(this);
        tv_position = (TextView) findViewById(R.id.tv_position);
        tv_wage = (TextView) findViewById(R.id.tv_wage);
        tv_workspace = (TextView) findViewById(R.id.tv_workspace);
        tv_workyear = (TextView) findViewById(R.id.tv_workyear);
        tv_education = (TextView) findViewById(R.id.tv_education);
        tv_company = (TextView) findViewById(R.id.tv_company);
        tv_companyinfo = (TextView) findViewById(R.id.tv_companyinfo);
        tv_founder = (TextView) findViewById(R.id.tv_founder);
        iv_cover= (ImageView) findViewById(R.id.iv_cover);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_companyinfo:
                Intent companyIntent = new Intent(this, CompanyActivity.class);
                startActivity(companyIntent);
                break;
        }
    }

    @Override
    public void updateRecruitmentInfo(RecruitmentInfo.DataBean dataBean) {
        Log.i("CJT",dataBean.getPattern());
        tv_position.setText(dataBean.getPosition());
        int wagestart = dataBean.getWagesstart() / 1000;
        int wageend = dataBean.getWagesend() / 1000;
        String wage = wagestart + "-" + wageend + "k";
        tv_wage.setText(wage);
        tv_workspace.setText(dataBean.getWorkplace());
        tv_workyear.setText(dataBean.getWorkingyearstart() + "-" + dataBean.getWorkingyearend() + "年");
        tv_education.setText(dataBean.getEducation());
        tv_company.setText(dataBean.getCompany());
        tv_companyinfo.setText(dataBean.getFinancing() + " | " + dataBean.getEmployenumber() + "人 | " + dataBean.getPattern());
        tv_founder.setText(dataBean.getFounder());
        Picasso.with(this).load(dataBean.getLogo()).into(iv_cover);
        hideProgressBar();
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
