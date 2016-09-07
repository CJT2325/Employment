package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.common.Config;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.presenter.UserInfoPresenter;
import com.cjt.employment.ui.view.UserInfoView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends BaseActivity<UserInfoActivity, UserInfoPresenter> implements View.OnClickListener, UserInfoView {
    private RelativeLayout layout_setting;
    private RelativeLayout layout_enterprise;
    private CircleImageView iv_cover;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    @Override
    protected UserInfoPresenter creatPresenter() {
        return new UserInfoPresenter();
    }

    private void initView() {
        layout_setting = (RelativeLayout) findViewById(R.id.layout_setting);
        layout_enterprise = (RelativeLayout) findViewById(R.id.layout_enterprise);
        layout_setting.setOnClickListener(this);
        layout_enterprise.setOnClickListener(this);
        iv_cover = (CircleImageView) findViewById(R.id.iv_cover);
        tv_name = (TextView) findViewById(R.id.tv_name);
        getPresenter().getUserCover("getUserInfo", Config.getValueByKey(this, Config.KEY_USERID));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_userinfo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_seacher) {
            return true;
        } else if (id == R.id.action_edit) {
//            Intent loginIntent=new Intent(this,LoginActivity.class);
            Intent userEditIntent = new Intent(this, UserEditActivity.class);
            startActivity(userEditIntent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_setting:
                Intent settingIntent = new Intent(this, SettingActivity.class);
                startActivity(settingIntent);
                break;
            case R.id.layout_enterprise:
//                Intent enterpriseIntent=new Intent(this,EnterpriseActivity.class);
                Intent enterpriseIntent = new Intent(this, EnterpriseHomeActivity.class);
                startActivity(enterpriseIntent);
                break;
        }
    }

    @Override
    public void getUserCoverSuccess(AccountInfo accountInfo) {
        Picasso.with(this).load(ServerAPI.baseUrl+"image/accountCover/" + accountInfo.getData().getCover()).into(iv_cover);
        tv_name.setText(accountInfo.getData().getName());
    }

    @Override
    public void getUserCoverFail() {

    }
}
