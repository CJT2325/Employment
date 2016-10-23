package com.cjt.employment.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.cjt.employment.R;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.RegisterPresenter;
import com.cjt.employment.ui.view.RegisterView;

public class RegisterActivity extends BaseActivity<RegisterActivity, RegisterPresenter> implements View.OnClickListener, RegisterView {
    private Button btn_register;
    private TextInputLayout textInput_layout_phone;
    private TextInputLayout textInput_layout_password1;
    private TextInputLayout textInput_layout_password2;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("用户注册");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    @Override
    protected RegisterPresenter creatPresenter() {
        return new RegisterPresenter();
    }

    private void initView() {
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        textInput_layout_phone = (TextInputLayout) findViewById(R.id.textInput_layout_phone);
        textInput_layout_password1 = (TextInputLayout) findViewById(R.id.textInput_layout_password1);
        textInput_layout_password2 = (TextInputLayout) findViewById(R.id.textInput_layout_password2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                if (textInput_layout_password1.getEditText().length() < 6) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("密码至少6位")
                            .setPositiveButton("重新输入", null).show();
                    break;
                } else if (!textInput_layout_password1.getEditText().getText().toString().equals(textInput_layout_password2.getEditText().getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("两次密码不相同")
                            .setPositiveButton("重新输入", null).show();
                    break;
                } else if (textInput_layout_phone.getEditText().getText().length() != 11) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("手机号码长度不是11位")
                            .setPositiveButton("重新输入", null).show();
                    break;
                } else {
                    getPresenter().resgister(
                            "resgister",
                            textInput_layout_phone.getEditText().getText().toString(),
                            textInput_layout_password1.getEditText().getText().toString()
                    );
                }
                break;
        }
    }

    @Override
    public void registerSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("注册成功")
                .setPositiveButton("返回登录界面", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RegisterActivity.this.finish();
                    }
                }).show();
    }

    @Override
    public void registerFail() {

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
