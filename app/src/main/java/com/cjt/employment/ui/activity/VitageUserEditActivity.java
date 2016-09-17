package com.cjt.employment.ui.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.model.IPickerViewData;
import com.cjt.employment.R;
import com.cjt.employment.bean.PickerViewData;
import com.cjt.employment.bean.ProvinceBean;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.VitageUserEditPresenter;
import com.cjt.employment.ui.view.VitageUserEditView;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VitageUserEditActivity extends BaseActivity<VitageUserEditActivity, VitageUserEditPresenter> implements View.OnClickListener,VitageUserEditView {
    private ProgressBar progressBar;
    private EditText et_name;
    private EditText et_phone;
    private EditText et_email;
    private EditText et_brithday;
    private EditText et_sex;
    private EditText et_education;
    private EditText et_worktime;
    private EditText et_city;
    private ArrayList<String> optionsSexItem = new ArrayList<>();
    private ArrayList<String> optionsEducationItem = new ArrayList<>();
    private ArrayList<String> optionsWorktimeItem = new ArrayList<>();

    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<IPickerViewData>>> options3Items = new ArrayList<>();

    OptionsPickerView sexOptions;
    OptionsPickerView cityOptions;
    OptionsPickerView educationOptions;
    OptionsPickerView worktimeOptions;
    TimePickerView pvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitage_user_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        initOption();
        initCityOption();
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
            if(et_name.getText().equals("")||
                    et_sex.getText().equals("")||
                    et_brithday.getText().equals("")||
                    et_education.getText().equals("")||
                    et_worktime.getText().equals("")||
                    et_phone.getText().equals("")||
                    et_email.getText().equals("")||
                    et_city.getText().equals("")
                    ){
                Toast.makeText(this,"请填满所有项目",Toast.LENGTH_SHORT).show();
            }else{
                getPresenter().updateVitageUser("updateVitageUser",
                        Config.getValueByKey(this,Config.KEY_USERID),
                        et_name.getText().toString(),
                        et_sex.getText().toString(),
                        et_brithday.getText().toString(),
                        et_education.getText().toString(),
                        et_worktime.getText().toString(),
                        et_phone.getText().toString(),
                        et_email.getText().toString(),
                        et_city.getText().toString()
                        );
            }
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected VitageUserEditPresenter creatPresenter() {
        return new VitageUserEditPresenter();
    }

    private void initCityOption() {
        //选项1
        String[] province = getResources().getStringArray(R.array.province);
        for (int i = 0; i < province.length; i++) {
            options1Items.add(new ProvinceBean(i, province[i], "", ""));
        }
//
//        options1Items.add(new ProvinceBean(1,"湖南","",""));
//        options1Items.add(new ProvinceBean(2,"广西","",""));

        //选项2
        ArrayList<String> options2Items_01 = new ArrayList<>();
        options2Items_01.add("广州");
        options2Items_01.add("佛山");
        options2Items_01.add("东莞");
        options2Items_01.add("阳江");
        options2Items_01.add("珠海");
        ArrayList<String> options2Items_02 = new ArrayList<>();
        options2Items_02.add("长沙");
        options2Items_02.add("岳阳");
        ArrayList<String> options2Items_03 = new ArrayList<>();
        options2Items_03.add("桂林");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);

        //选项3
        ArrayList<ArrayList<IPickerViewData>> options3Items_01 = new ArrayList<>();
        ArrayList<ArrayList<IPickerViewData>> options3Items_02 = new ArrayList<>();
        ArrayList<ArrayList<IPickerViewData>> options3Items_03 = new ArrayList<>();
        ArrayList<IPickerViewData> options3Items_01_01 = new ArrayList<>();
        options3Items_01_01.add(new PickerViewData("天河"));
        options3Items_01_01.add(new PickerViewData("黄埔"));
        options3Items_01_01.add(new PickerViewData("海珠"));
        options3Items_01_01.add(new PickerViewData("越秀"));
        options3Items_01.add(options3Items_01_01);
        ArrayList<IPickerViewData> options3Items_01_02 = new ArrayList<>();
        options3Items_01_02.add(new PickerViewData("南海"));
        options3Items_01_02.add(new PickerViewData("高明"));
        options3Items_01_02.add(new PickerViewData("禅城"));
        options3Items_01_02.add(new PickerViewData("桂城"));
        options3Items_01.add(options3Items_01_02);
        ArrayList<IPickerViewData> options3Items_01_03 = new ArrayList<>();
        options3Items_01_03.add(new PickerViewData("其他"));
        options3Items_01_03.add(new PickerViewData("常平"));
        options3Items_01_03.add(new PickerViewData("虎门"));
        options3Items_01.add(options3Items_01_03);
        ArrayList<IPickerViewData> options3Items_01_04 = new ArrayList<>();
        options3Items_01_04.add(new PickerViewData("其他"));
        options3Items_01_04.add(new PickerViewData("其他"));
        options3Items_01_04.add(new PickerViewData("其他"));
        options3Items_01.add(options3Items_01_04);
        ArrayList<IPickerViewData> options3Items_01_05 = new ArrayList<>();

        options3Items_01_05.add(new PickerViewData("其他1"));
        options3Items_01_05.add(new PickerViewData("其他2"));
        options3Items_01.add(options3Items_01_05);

        ArrayList<IPickerViewData> options3Items_02_01 = new ArrayList<>();

        options3Items_02_01.add(new PickerViewData("长沙1"));
        options3Items_02_01.add(new PickerViewData("长沙2"));
        options3Items_02_01.add(new PickerViewData("长沙3"));
        options3Items_02_01.add(new PickerViewData("长沙4"));
        options3Items_02_01.add(new PickerViewData("长沙5"));


        options3Items_02.add(options3Items_02_01);
        ArrayList<IPickerViewData> options3Items_02_02 = new ArrayList<>();

        options3Items_02_02.add(new PickerViewData("岳阳"));
        options3Items_02_02.add(new PickerViewData("岳阳1"));
        options3Items_02_02.add(new PickerViewData("岳阳2"));
        options3Items_02_02.add(new PickerViewData("岳阳3"));
        options3Items_02_02.add(new PickerViewData("岳阳4"));
        options3Items_02_02.add(new PickerViewData("岳阳5"));

        options3Items_02.add(options3Items_02_02);
        ArrayList<IPickerViewData> options3Items_03_01 = new ArrayList<>();
        options3Items_03_01.add(new PickerViewData("好山水"));
        options3Items_03.add(options3Items_03_01);

        options3Items.add(options3Items_01);
        options3Items.add(options3Items_02);
        options3Items.add(options3Items_03);
        cityOptions = new OptionsPickerView(this);
        //三级联动效果
        cityOptions.setPicker(options1Items, options2Items, options3Items, true);
        //设置选择的三级单位
//        pwOptions.setLabels("省", "市", "区");
        cityOptions.setTitle("选择城市");
        cityOptions.setCyclic(false, false, false);
        //设置默认选中的三级项目
        //监听确定选择按钮
        cityOptions.setSelectOptions(1, 1, 1);
        cityOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()
                        + options2Items.get(options1).get(option2)
                        + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
                et_city.setText(tx);
            }
        });
    }

    private void initOption() {
        //性别选择框
        sexOptions = new OptionsPickerView(this);
        sexOptions.setTitle("选择性别");
        optionsSexItem.add("男");
        optionsSexItem.add("女");
        sexOptions.setPicker(optionsSexItem);
        sexOptions.setCyclic(false);
        sexOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = optionsSexItem.get(options1);
                et_sex.setText(tx);
            }
        });
        //学历选择框
        educationOptions = new OptionsPickerView(this);
        educationOptions.setTitle("最高学历");
        optionsEducationItem.add("大专");
        optionsEducationItem.add("本科");
        optionsEducationItem.add("硕士");
        optionsEducationItem.add("博士");
        optionsEducationItem.add("其他");
        educationOptions.setPicker(optionsEducationItem);
        educationOptions.setCyclic(false);
        educationOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = optionsEducationItem.get(options1);
                et_education.setText(tx);
            }
        });

        //工作年限选择框
        worktimeOptions = new OptionsPickerView(this);
        worktimeOptions.setTitle("工作年限");
        optionsWorktimeItem.add("应届毕业生");
        for (int i = 1; i <= 10; i++) {
            optionsWorktimeItem.add(i + "年");
        }
        optionsWorktimeItem.add("10年以上");
        worktimeOptions.setPicker(optionsWorktimeItem);
        worktimeOptions.setCyclic(false);
        worktimeOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = optionsWorktimeItem.get(options1);
                et_worktime.setText(tx);
            }
        });

        //出生年月
        //时间选择器
        pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH);
        //控制时间范围
        Calendar calendar = Calendar.getInstance();
        pvTime.setRange(calendar.get(Calendar.YEAR) - 60, calendar.get(Calendar.YEAR));//要在setTime 之前才有效果哦
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                et_brithday.setText(getTime(date));
            }
        });
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

    private void initView() {
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);
        et_brithday = (EditText) findViewById(R.id.et_brithday);
        et_sex = (EditText) findViewById(R.id.et_sex);
        et_education = (EditText) findViewById(R.id.et_education);
        et_worktime = (EditText) findViewById(R.id.et_worktime);
        et_city = (EditText) findViewById(R.id.et_city);

        et_brithday.setOnClickListener(this);
        et_sex.setOnClickListener(this);
        et_education.setOnClickListener(this);
        et_worktime.setOnClickListener(this);
        et_city.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //1.得到InputMethodManager对象
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //2.调用hideSoftInputFromWindow方法隐藏软键盘
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
        switch (v.getId()) {
            case R.id.et_brithday:
                pvTime.show();
                break;
            case R.id.et_sex:
                sexOptions.show();
                break;
            case R.id.et_education:
                educationOptions.show();
                break;
            case R.id.et_worktime:
                worktimeOptions.show();
                break;
            case R.id.et_city:
                cityOptions.show();
                break;
        }
    }

    @Override
    public void updateSuccess() {
        hideProgressBar();
        Intent intent=new Intent();
        intent.putExtra("name",et_name.getText().toString());
        intent.putExtra("sex",et_sex.getText().toString());
        intent.putExtra("brithday",et_brithday.getText().toString());
        intent.putExtra("education",et_education.getText().toString());
        intent.putExtra("worktime",et_worktime.getText().toString());
        intent.putExtra("phone",et_phone.getText().toString());
        intent.putExtra("email",et_email.getText().toString());
        intent.putExtra("city",et_city.getText().toString());
        setResult(1,intent);
        finish();
    }

    @Override
    public void updateFail() {
        Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
        hideProgressBar();
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
