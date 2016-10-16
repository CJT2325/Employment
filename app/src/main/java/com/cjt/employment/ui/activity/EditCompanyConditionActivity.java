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
import com.cjt.employment.presenter.EditCompanyConditionPresenter;

public class EditCompanyConditionActivity extends BaseActivity<EditCompanyConditionActivity, EditCompanyConditionPresenter> {
    private EditText et_financting;
    private EditText et_pattern;
    private EditText et_startnumber;
    private EditText et_endnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_company_condition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("企业情况");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        et_financting = (EditText) findViewById(R.id.et_financting);
        et_pattern = (EditText) findViewById(R.id.et_pattern);
        et_startnumber = (EditText) findViewById(R.id.et_startnumber);
        et_endnumber = (EditText) findViewById(R.id.et_endnumber);
        Intent intent = getIntent();
        et_financting.setText(intent.getStringExtra("financing"));
        et_pattern.setText(intent.getStringExtra("pattern"));
        String number = intent.getStringExtra("number");
        String str[] = number.split("-");
        et_startnumber.setText(str[0]);
        et_endnumber.setText(str[1]);
    }

    @Override
    protected EditCompanyConditionPresenter creatPresenter() {
        return new EditCompanyConditionPresenter();
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
            if (et_financting.getText().toString().equals("")||
                    et_pattern.getText().toString().equals("")||
                    et_startnumber.getText().toString().equals("")||
                    et_endnumber.getText().toString().equals("")){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage("没有输入名字，请重新填写")
                        .setPositiveButton("我知道了",null).show();
            }else if(Integer.parseInt(et_startnumber.getText().toString())>=Integer.parseInt(et_endnumber.getText().toString())){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage("企业人数输入错误")
                        .setPositiveButton("我知道了",null).show();
            }
            else {
                Intent intent = new Intent();
                intent.putExtra("financing", et_financting.getText().toString());
                intent.putExtra("pattern", et_pattern.getText().toString());
                intent.putExtra("startnumber", et_startnumber.getText().toString());
                intent.putExtra("endnumber", et_endnumber.getText().toString());
                setResult(-1, intent);
                finish();
            }
        }


        return super.onOptionsItemSelected(item);
    }
}
