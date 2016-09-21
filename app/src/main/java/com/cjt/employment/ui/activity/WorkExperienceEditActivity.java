package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.BasePresenter;
import com.cjt.employment.presenter.WorkExperienceEditPresenter;

public class WorkExperienceEditActivity extends BaseActivity<WorkExperienceEditActivity, WorkExperienceEditPresenter> implements View.OnClickListener {
    private TextView tv_addworkexperience;

    private EditText et_companyname;
    private EditText et_position;
    private EditText et_starttime;
    private EditText et_endtime;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_experience_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("编辑工作经历");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        tv_addworkexperience = (TextView) findViewById(R.id.tv_addworkexperience);
        tv_addworkexperience.setOnClickListener(this);

        et_companyname = (EditText) findViewById(R.id.et_companyname);
        et_position = (EditText) findViewById(R.id.et_position);
        et_starttime = (EditText) findViewById(R.id.et_starttime);
        et_endtime = (EditText) findViewById(R.id.et_endtime);
        et_content = (EditText) findViewById(R.id.et_content);
    }

    @Override
    protected WorkExperienceEditPresenter creatPresenter() {
        return new WorkExperienceEditPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_useredit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            if (et_companyname.getText().equals("") ||
                    et_position.getText().equals("") ||
                    et_starttime.getText().equals("") ||
                    et_endtime.getText().equals("") ||
                    et_content.getText().equals("")
                    ) {
                Toast.makeText(this, "请填满所有项目", Toast.LENGTH_SHORT).show();
            } else {
                getPresenter().addWorkExperience("addWorkExperience",
                        Config.getValueByKey(this, Config.KEY_USERID),
                        et_companyname.getText().toString(),
                        et_position.getText().toString(),
                        et_starttime.getText().toString(),
                        et_endtime.getText().toString(),
                        et_content.getText().toString()
                );
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_addworkexperience:
                getPresenter();
                break;
        }
    }
}
