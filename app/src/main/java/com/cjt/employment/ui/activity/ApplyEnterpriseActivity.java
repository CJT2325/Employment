package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.ApplyEnterprisePresenter;
import com.cjt.employment.ui.view.ApplyEnterpriseView;

public class ApplyEnterpriseActivity extends BaseActivity<ApplyEnterpriseActivity, ApplyEnterprisePresenter> implements View.OnClickListener,ApplyEnterpriseView {
    private EditText et_companyname;
    private EditText et_phone;
    private Button btn_apply;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_enterprise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("企业版申请");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        et_companyname = (EditText) findViewById(R.id.et_companyname);
        et_phone = (EditText) findViewById(R.id.et_phone);
        btn_apply = (Button) findViewById(R.id.btn_apply);
        btn_apply.setOnClickListener(this);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
    }

    @Override
    protected ApplyEnterprisePresenter creatPresenter() {
        return new ApplyEnterprisePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_apply:
                String companyname = et_companyname.getText().toString();
                if (!companyname.equals("")) {
                    getPresenter().applyEnterprise("applyEnterprise", Config.getValueByKey(this, Config.KEY_USERID), companyname);
                }
                break;
        }
    }

    @Override
    public void applySuccess() {
        Toast.makeText(this,"申请成功，等待审核",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void applyFail() {
        Toast.makeText(this,"申请失败，请重试",Toast.LENGTH_SHORT).show();
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
