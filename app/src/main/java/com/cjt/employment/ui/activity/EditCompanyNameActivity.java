package com.cjt.employment.ui.activity;

import android.content.Intent;
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

import com.cjt.employment.R;
import com.cjt.employment.presenter.EditCompanyNamePresenter;

public class EditCompanyNameActivity extends BaseActivity<EditCompanyNameActivity,EditCompanyNamePresenter> {
    private EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_company_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("企业名称");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        et_name.setText(getIntent().getStringExtra("name"));
    }

    private void initView() {
        et_name= (EditText) findViewById(R.id.et_name);
    }

    @Override
    protected EditCompanyNamePresenter creatPresenter() {
        return new EditCompanyNamePresenter();
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
            if (et_name.getText().toString().equals("")){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage("没有输入名字，请重新填写")
                        .setPositiveButton("我知道了",null).show();
            }else {
                Intent intent = new Intent();
                intent.putExtra("name", et_name.getText().toString());
                setResult(-1, intent);
                finish();
            }
        }


        return super.onOptionsItemSelected(item);
    }
}
