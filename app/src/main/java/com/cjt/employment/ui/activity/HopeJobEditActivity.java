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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.HopeJobPresenter;
import com.cjt.employment.ui.view.HopeJobView;

public class HopeJobEditActivity extends BaseActivity<HopeJobEditActivity,HopeJobPresenter> implements HopeJobView {

    private ProgressBar progressBar;

    private TextView et_hopeposition;
    private TextView et_jobtype;
    private TextView et_city;
    private TextView et_money;
    private TextView et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hope_job_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("期望工作");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        et_hopeposition= (TextView) findViewById(R.id.et_hopeposition);
        et_jobtype= (TextView) findViewById(R.id.et_jobtype);
        et_city= (TextView) findViewById(R.id.et_city);
        et_money= (TextView) findViewById(R.id.et_money);
        et_content= (TextView) findViewById(R.id.et_content);

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
            if (et_hopeposition.getText().equals("") ||
                    et_jobtype.getText().equals("") ||
                    et_city.getText().equals("") ||
                    et_money.getText().equals("")
                    ) {
                Toast.makeText(this, "请填满所有项目", Toast.LENGTH_SHORT).show();
            } else {
                getPresenter().updateHopeJob("updateHopeJob",
                        Config.getValueByKey(this, Config.KEY_USERID),
                        et_hopeposition.getText().toString(),
                        et_jobtype.getText().toString(),
                        et_city.getText().toString(),
                        et_money.getText().toString(),
                        et_content.getText().toString()
                );
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected HopeJobPresenter creatPresenter() {
        return new HopeJobPresenter();
    }

    @Override
    public void updateSuccess() {
        hideProgressBar();
        finish();
    }

    @Override
    public void updateFail() {
        hideProgressBar();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("保存失败")
                .setPositiveButton("返回", null)
                .show();
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
