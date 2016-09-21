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
import com.cjt.employment.presenter.EducationEditPresenter;

public class EducationEditActivity extends BaseActivity<EducationEditActivity,EducationEditPresenter> {

    private EditText et_schoolname;
    private EditText et_major;
    private EditText et_graduationtime;
    private EditText et_education;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("编辑教育经历");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

    }

    @Override
    protected EducationEditPresenter creatPresenter() {
        return new EducationEditPresenter();
    }

    private void initView() {
        et_schoolname = (EditText) findViewById(R.id.et_schoolname);
        et_major = (EditText) findViewById(R.id.et_major);
        et_graduationtime = (EditText) findViewById(R.id.et_graduationtime);
        et_education = (EditText) findViewById(R.id.et_education);
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
            if (et_schoolname.getText().equals("") ||
                    et_major.getText().equals("") ||
                    et_graduationtime.getText().equals("") ||
                    et_education.getText().equals("")
                    ) {
                Toast.makeText(this, "请填满所有项目", Toast.LENGTH_SHORT).show();
            } else {
                getPresenter().addEducation("addEducation",
                        Config.getValueByKey(this, Config.KEY_USERID),
                        et_schoolname.getText().toString(),
                        et_major.getText().toString(),
                        et_graduationtime.getText().toString(),
                        et_education.getText().toString()
                );
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
