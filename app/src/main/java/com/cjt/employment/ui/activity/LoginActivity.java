package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.common.Config;
import com.cjt.employment.common.DemoCache;
import com.cjt.employment.presenter.LoginPresenter;
import com.cjt.employment.ui.view.LoginView;
import com.cjt.employment.ui.view.MainView;
import com.netease.nim.uikit.NimUIKit;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;

import java.util.prefs.Preferences;

public class LoginActivity extends BaseActivity<LoginActivity, LoginPresenter> implements View.OnClickListener, LoginView {
    private Button btn_login;
    private Button btn_register;
    private TextInputLayout textInput_layout_phone;
    private TextInputLayout textInput_layout_password;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    @Override
    protected LoginPresenter creatPresenter() {
        return new LoginPresenter();
    }

    private void initView() {
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        textInput_layout_phone = (TextInputLayout) findViewById(R.id.textInput_layout_phone);
        textInput_layout_password = (TextInputLayout) findViewById(R.id.textInput_layout_password);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_seacher) {
            return true;
        }
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_userlogin, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                Intent registerIntent = new Intent(this, RegisterActivity.class);
                startActivity(registerIntent);
                break;
            case R.id.btn_login:
                String phone = textInput_layout_phone.getEditText().getText().toString();
                String password = textInput_layout_password.getEditText().getText().toString();
                if (!phone.equals("") && !password.equals("")) {
                    getPresenter().login("login", phone, password);
//                    doLogin(phone, password);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("电话号码或密码不能为空")
                            .setPositiveButton("确定", null)
                            .show();
                }
                break;
        }
    }

    @Override
    public void loginSuccess(LoginResult loginResult) {
        String password = textInput_layout_password.getEditText().getText().toString();
        hideProgressBar();
        Config.saveValueByKey(this, Config.KEY_TOKEN, loginResult.getToken());
        Config.saveValueByKey(this, Config.KEY_USERID, String.valueOf(loginResult.getId()));
        doLogin(loginResult.getId()+"", password);
//        this.finish();
    }

    @Override
    public void loginFail() {
        Toast.makeText(LoginActivity.this, "登录失败 ", Toast.LENGTH_SHORT).show();
//        hideProgressBar();
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("登录失败")
//                .setPositiveButton("确定", null)
//                .show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void doLogin(final String account, final String password) {
        LoginInfo info = new LoginInfo(account, password); // config...
        RequestCallback<LoginInfo> callback =
                new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo loginInfo) {
                        Toast.makeText(LoginActivity.this, "登录成功 " + account, Toast.LENGTH_SHORT).show();
                        NimUIKit.setAccount(account);
                        DemoCache.setAccount(account);
                        saveLoginInfo(account, password);
                        Intent mianIntent=new Intent(LoginActivity.this, MainActivity.class);
                        LoginActivity.this.startActivity(mianIntent);
                        LoginActivity.this.finish();
                    }

                    @Override
                    public void onFailed(int i) {
                        Toast.makeText(LoginActivity.this, "登录失败 " + i, Toast.LENGTH_SHORT).show();
//                        hideProgressBar();
//                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                        builder.setMessage("登录失败")
//                                .setPositiveButton("确定", null)
//                                .show();
                    }

                    @Override
                    public void onException(Throwable throwable) {

                    }
                    // 可以在此保存LoginInfo到本地，下次启动APP做自动登录用
                };
        NIMClient.getService(AuthService.class).login(info)
                .setCallback(callback);
    }

    private void saveLoginInfo(final String account, final String token) {
        Config.saveUserAccount(account);
        Config.saveUserToken(token);
    }
}
