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
import android.widget.Toast;

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
    private RelativeLayout layout_vitae;
    private RelativeLayout layout_collection;
    private CircleImageView iv_cover;
    private TextView tv_name;

    private String isEnterprise = "-1";

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
    protected void onStart() {
        super.onStart();
        getPresenter().getUserCover("getUserInfo", Config.getValueByKey(this, Config.KEY_USERID));
    }

    @Override
    protected UserInfoPresenter creatPresenter() {
        return new UserInfoPresenter();
    }

    private void initView() {
        layout_setting = (RelativeLayout) findViewById(R.id.layout_setting);
        layout_enterprise = (RelativeLayout) findViewById(R.id.layout_enterprise);
        layout_vitae = (RelativeLayout) findViewById(R.id.layout_vitae);
        layout_collection = (RelativeLayout) findViewById(R.id.layout_collection);
        layout_setting.setOnClickListener(this);
        layout_enterprise.setOnClickListener(this);
        layout_vitae.setOnClickListener(this);
        layout_collection.setOnClickListener(this);
        iv_cover = (CircleImageView) findViewById(R.id.iv_cover);
        tv_name = (TextView) findViewById(R.id.tv_name);

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
                if (isEnterprise.equals("1")) {
                    Intent enterpriseIntent = new Intent(this, EnterpriseHomeActivity.class);
                    startActivity(enterpriseIntent);
                } else if (isEnterprise.equals("0")) {
                    Toast.makeText(this, "请等待审核..", Toast.LENGTH_SHORT).show();
                } else if (isEnterprise.equals("-1")) {
                    Intent applyEnterpriseIntent = new Intent(this, ApplyEnterpriseActivity.class);
                    startActivity(applyEnterpriseIntent);
                }
                break;
            case R.id.layout_vitae:
                Intent vitaeIntent = new Intent(this, VitaeActivity.class);
                startActivity(vitaeIntent);
                break;
            case R.id.layout_collection:
                Intent collectionIntent = new Intent(this, CollectionActivity.class);
                startActivity(collectionIntent);
                break;
        }
    }

    @Override
    public void getUserCoverSuccess(AccountInfo accountInfo) {
        Picasso.with(this).load(ServerAPI.baseUrl + "image/accountCover/" + accountInfo.getData().getCover()).error(R.drawable.ic_person_black_24dp).into(iv_cover);
        tv_name.setText(accountInfo.getData().getName());
        isEnterprise = accountInfo.getData().getIsEnterprise();
    }

    @Override
    public void getUserCoverFail() {

    }
}
