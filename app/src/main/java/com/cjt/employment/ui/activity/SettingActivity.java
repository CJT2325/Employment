package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.cjt.employment.R;
import com.cjt.employment.presenter.SettingPresenter;
import com.cjt.employment.ui.view.SettingView;

public class SettingActivity extends BaseActivity<SettingActivity,SettingPresenter> implements View.OnClickListener, SettingView {
    private RelativeLayout layout_logout;
    private RelativeLayout layout_changepwd;
    private RelativeLayout layout_clear;
    private RelativeLayout layout_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("设置");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    @Override
    protected SettingPresenter creatPresenter() {
        return new SettingPresenter();
    }

    private void initView() {
        layout_logout = (RelativeLayout) findViewById(R.id.layout_logout);
        layout_changepwd = (RelativeLayout) findViewById(R.id.layout_changepwd);
        layout_clear = (RelativeLayout) findViewById(R.id.layout_clear);
        layout_about = (RelativeLayout) findViewById(R.id.layout_about);
        layout_logout.setOnClickListener(this);
        layout_changepwd.setOnClickListener(this);
        layout_clear.setOnClickListener(this);
        layout_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_changepwd:
                break;
            case R.id.layout_clear:
                break;
            case R.id.layout_about:
                break;
            case R.id.layout_logout:
                break;
        }
    }
}
