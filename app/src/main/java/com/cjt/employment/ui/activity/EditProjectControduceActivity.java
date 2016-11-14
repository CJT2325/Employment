package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.cjt.employment.R;
import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.CompanyProject;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.EditProjectControducePresenter;
import com.cjt.employment.ui.view.EditProjectControduceView;

public class EditProjectControduceActivity extends BaseActivity<EditProjectControduceActivity,EditProjectControducePresenter> implements EditProjectControduceView {
    private EditText et_content;
    private ProgressBar progressBar;
    private String content;

    public EditProjectControduceActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project_controduce);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("产品介绍");
        setSupportActionBar(toolbar);
        initView();
        getPresenter().getProjectControduceById("getProjectControduceById", Config.getValueByKey(this,Config.KEY_USERID));
    }

    @Override
    protected EditProjectControducePresenter creatPresenter() {
        return new EditProjectControducePresenter();
    }

    private void initView() {
        et_content= (EditText) findViewById(R.id.et_content);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
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
            if (et_content.getText().toString().equals("")){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage("产品介绍不能为空")
                        .setPositiveButton("我知道了",null).show();
            }else if(et_content.getText().equals(content)) {
                finish();
            }else{
                getPresenter().updateProjectControduceById("updateProjectControduceById", Config.getValueByKey(this,Config.KEY_USERID),et_content.getText().toString());
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getProjectControduceSuccess(CompanyProject.DataBean data) {
        et_content.setText(data.getProject());
        this.content=data.getProject();
    }

    @Override
    public void updateSuccess() {
        finish();
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
