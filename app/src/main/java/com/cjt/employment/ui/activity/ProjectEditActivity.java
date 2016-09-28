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
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.bean.Project;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.ProjectEditPresenter;

public class ProjectEditActivity extends BaseActivity<ProjectEditActivity,ProjectEditPresenter> {

    private EditText et_projectname;
    private EditText et_responsibility;
    private EditText et_starttime;
    private EditText et_endtime;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
    }

    @Override
    protected ProjectEditPresenter creatPresenter() {
        return new ProjectEditPresenter();
    }

    private void initView() {
        et_projectname = (EditText) findViewById(R.id.et_projectname);
        et_responsibility = (EditText) findViewById(R.id.et_responsibility);
        et_starttime = (EditText) findViewById(R.id.et_starttime);
        et_endtime = (EditText) findViewById(R.id.et_endtime);
        et_content = (EditText) findViewById(R.id.et_content);
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
            if (et_projectname.getText().equals("") ||
                    et_responsibility.getText().equals("") ||
                    et_starttime.getText().equals("") ||
                    et_endtime.getText().equals("") ||
                    et_content.getText().equals("")
                    ) {
                Toast.makeText(this, "请填满所有项目", Toast.LENGTH_SHORT).show();
            } else {
                getPresenter().addProject("addProject",
                        Config.getValueByKey(this, Config.KEY_USERID),
                        et_projectname.getText().toString(),
                        et_responsibility.getText().toString(),
                        et_starttime.getText().toString(),
                        et_endtime.getText().toString(),
                        et_content.getText().toString()
                );
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
