package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.cjt.employment.R;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.VitageInfo;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.presenter.VitageInfoPresenter;
import com.cjt.employment.ui.view.VitageInfoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VitageInfoActivity extends BaseActivity<VitageInfoActivity, VitageInfoPresenter> implements View.OnClickListener, VitageInfoView {
    private ProgressBar progressBar;
    private Button btn_vitagestate;
    private Button btn_seevitage;
    //基本信息
    private TextView tv_name;
    private TextView tv_sex;
    private TextView tv_brithday;
    private TextView tv_education;
    private TextView tv_worktime;
    private TextView tv_phone;
    private TextView tv_email;
    private TextView tv_city;


    private ImageView iv_cover;
    private TextView tv_position;
    private TextView tv_company;
    private TextView tv_wage;
    private TextView tv_date;
    private TextView tv_recruitinfo;
    private TextView tv_companyinfo;

    private int accountID = -1;
    private String vitageID = "";

    private OptionsPickerView typeOptions;
    private ArrayList<String> optionsTypeItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitage_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("简历详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
        initOption();
    }

    @Override
    protected void onStart() {
        vitageID = getIntent().getStringExtra("id");
        super.onStart();
        getPresenter().getVitageInfoById("getVitageInfoById", vitageID);
    }

    private void initOption() {

        //工作类型选择框
        typeOptions = new OptionsPickerView(this);
        typeOptions.setTitle("简历状态");
        optionsTypeItem.add("未处理");
        optionsTypeItem.add("待面试");
        optionsTypeItem.add("不合适");
        typeOptions.setPicker(optionsTypeItem);
        typeOptions.setCyclic(false);
        typeOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = optionsTypeItem.get(options1);
                String state = "";
                if (tx.equals("未处理")) {
                    state = "0";
                } else if (tx.equals("待面试")) {
                    state = "2";
                } else if (tx.equals("不合适")) {
                    state = "3";
                }
                getPresenter().updateVitageState("updateVitageState", vitageID, state);
                btn_vitagestate.setText("简历状态：" + tx);
            }
        });
    }

    private void initView() {
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        btn_vitagestate = (Button) findViewById(R.id.btn_vitagestate);
        btn_seevitage = (Button) findViewById(R.id.btn_seevitage);
        btn_vitagestate.setOnClickListener(this);
        btn_seevitage.setOnClickListener(this);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_brithday = (TextView) findViewById(R.id.tv_brithday);
        tv_education = (TextView) findViewById(R.id.tv_education);
        tv_worktime = (TextView) findViewById(R.id.tv_worktime);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_city = (TextView) findViewById(R.id.tv_city);


        iv_cover = (ImageView) findViewById(R.id.iv_cover);
        tv_position = (TextView) findViewById(R.id.tv_position);
        tv_company = (TextView) findViewById(R.id.tv_company);
        tv_wage = (TextView) findViewById(R.id.tv_wage);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_recruitinfo = (TextView) findViewById(R.id.tv_recruitinfo);
        tv_companyinfo = (TextView) findViewById(R.id.tv_companyinfo);
    }

    @Override
    protected VitageInfoPresenter creatPresenter() {
        return new VitageInfoPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vitagestate:
                typeOptions.show();
                break;
            case R.id.btn_seevitage:
                Intent browseVitageIntent = new Intent(this, BrowseVitageActivity.class);
                browseVitageIntent.putExtra("id", accountID + "");
                startActivity(browseVitageIntent);
                break;
        }
    }

    @Override
    public void updateVitageState(int state) {
        switch (state) {
            case 0:
                btn_vitagestate.setText("简历状态：未处理");
                break;
            case 2:
                btn_vitagestate.setText("简历状态：待面试");
                break;
            case 3:
                btn_vitagestate.setText("简历状态：不合适");
                break;
        }
    }

    @Override
    public void getVitageInfoFail() {

    }

    @Override
    public void getVitageInfoSuccess(VitageInfo.DataBean data) {
        accountID = data.getAccountid();

        tv_name.setText("姓        名:  " + data.getName());
        tv_sex.setText("性        别:  " + data.getSex());
        tv_brithday.setText("出生年份:  " + data.getBrithday());
        tv_education.setText("最高学历:  " + data.getEducation());
        tv_worktime.setText("工作年限:  " + data.getWorktime());
        tv_phone.setText("联系电话:  " + data.getPhone());
        tv_email.setText("联系邮箱:  " + data.getEmail());
        tv_city.setText("所在城市:  " + data.getCity());

        Picasso.with(this).load(ServerAPI.baseUrl + "image/companyCover/" + data.getLogo()).into(iv_cover);
        tv_position.setText(data.getPosition());
        tv_company.setText(data.getCompany());
        tv_date.setText(data.getReleasedate());
        int wagestart = data.getWagesstart() / 1000;
        int wageend = data.getWagesend() / 1000;
        String wage = wagestart + "-" + wageend + "k";
        tv_wage.setText(wage);
        tv_recruitinfo.setText(data.getWorkplace() + " " + data.getWorkingyearstart() + "-" + data.getWorkingyearend() + "年" + " " + data.getEducation());
        tv_companyinfo.setText(data.getFinancing() + " | " + data.getEmployenumber() + "人 | " + data.getPattern());
        //0:未处理 1被查看 2呆面试 3不合适
        switch (data.getState()) {
            case 0:
                btn_vitagestate.setText("简历状态：未处理");
                break;
//            case 1:
//                btn_vitagestate.setText("简历状态：未处理");
//                break;
            case 2:
                btn_vitagestate.setText("简历状态：待面试");
                break;
            case 3:
                btn_vitagestate.setText("简历状态：不合适");
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
