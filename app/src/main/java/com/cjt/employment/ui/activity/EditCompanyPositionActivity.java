package com.cjt.employment.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.model.IPickerViewData;
import com.cjt.employment.R;
import com.cjt.employment.bean.CompanyPosition;
import com.cjt.employment.bean.PickerViewData;
import com.cjt.employment.bean.ProvinceBean;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.EditCompanyPositionPresenter;
import com.cjt.employment.ui.view.EditCompanyPositionView;

import java.util.ArrayList;

public class EditCompanyPositionActivity extends BaseActivity<EditCompanyPositionActivity, EditCompanyPositionPresenter> implements View.OnClickListener, EditCompanyPositionView {
    private EditText et_name;
    private EditText et_type;
    private EditText et_education;
    private EditText et_number;
    private EditText et_city;
    private EditText et_address;
    private EditText et_content;

    private ProgressBar progressBar;

    private EditText et_startwages;
    private EditText et_endwages;
    private EditText et_startworktime;
    private EditText et_endworktime;

    private ArrayList<String> optionsTypeItem = new ArrayList<>();
    private ArrayList<String> optionsEducationItem = new ArrayList<>();

    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<IPickerViewData>>> options3Items = new ArrayList<>();

    OptionsPickerView typeOptions;
    OptionsPickerView educationOptions;
    OptionsPickerView cityOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_company_position);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("职位编辑");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        initOption();
        initCityOption();
        int id = getIntent().getIntExtra("id", -1);
        Log.i("CJT", "id=" + id);
        if (id != -1) {
            getPresenter().getCompanyPositionById("getCompanyPositionById", id+"");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
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
//                String tx = options1Items.get(options1).getPickerViewText()
//                        + options2Items.get(options1).get(option2)
//                        + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
                et_city.setText(options2Items.get(options1).get(option2));
            }
        });
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_type = (EditText) findViewById(R.id.et_type);
        et_education = (EditText) findViewById(R.id.et_education);
        et_number = (EditText) findViewById(R.id.et_number);
        et_city = (EditText) findViewById(R.id.et_city);
        et_address = (EditText) findViewById(R.id.et_address);
        et_content = (EditText) findViewById(R.id.et_content);
        et_startwages = (EditText) findViewById(R.id.et_startnumber);
        et_endwages = (EditText) findViewById(R.id.et_endnumber);
        et_startworktime = (EditText) findViewById(R.id.et_startworktime);
        et_endworktime = (EditText) findViewById(R.id.et_endworktime);

        et_type.setOnClickListener(this);
        et_education.setOnClickListener(this);
        et_city.setOnClickListener(this);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }

    private void initOption() {
        //工作类型选择框
        typeOptions = new OptionsPickerView(this);
        typeOptions.setTitle("工作类型");
        optionsTypeItem.add("全职");
        optionsTypeItem.add("实习");
        optionsTypeItem.add("兼职");
        optionsTypeItem.add("应届毕业生");
        typeOptions.setPicker(optionsTypeItem);
        typeOptions.setCyclic(false);
        typeOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = optionsTypeItem.get(options1);
                et_type.setText(tx);
            }
        });

        //学历选择框
        educationOptions = new OptionsPickerView(this);
        educationOptions.setTitle("学历");
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

    }

    @Override
    protected EditCompanyPositionPresenter creatPresenter() {
        return new EditCompanyPositionPresenter();
    }

    @Override
    public void onClick(View v) {
        //1.得到InputMethodManager对象
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //2.调用hideSoftInputFromWindow方法隐藏软键盘
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
        switch (v.getId()) {
            case R.id.et_type:
                typeOptions.show();
                break;
            case R.id.et_education:
                educationOptions.show();
                break;
            case R.id.et_city:
                cityOptions.show();
                break;
        }
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
            if (et_name.getText().toString().equals("") ||
                    et_type.getText().toString().equals("") ||
                    et_education.getText().toString().equals("") ||
                    et_number.getText().toString().equals("") ||
                    et_city.getText().toString().equals("") ||
                    et_startwages.getText().toString().equals("") ||
                    et_endwages.getText().toString().equals("") ||
                    et_startworktime.getText().toString().equals("") ||
                    et_endworktime.getText().toString().equals("") ||
                    et_address.getText().toString().equals("") ||
                    et_content.getText().toString().equals("")
                    ) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("请填满所有项目")
                        .setPositiveButton("我知道了", null).show();
            } else if (Integer.parseInt(et_startwages.getText().toString()) > Integer.parseInt(et_endwages.getText().toString())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("工作薪资输入错误")
                        .setPositiveButton("我知道了", null).show();
            } else if (Integer.parseInt(et_startworktime.getText().toString()) > Integer.parseInt(et_endworktime.getText().toString())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("工作经验输入错误")
                        .setPositiveButton("我知道了", null).show();
            } else {
                getPresenter().addCompanyPosition("addCompanyPosition",
                        Config.getValueByKey(this, Config.KEY_USERID),
                        et_name.getText().toString(),
                        et_type.getText().toString(),
                        et_education.getText().toString(),
                        et_number.getText().toString(),
                        et_startwages.getText().toString(),
                        et_endwages.getText().toString(),
                        et_startworktime.getText().toString(),
                        et_endworktime.getText().toString(),
                        et_city.getText().toString(),
                        et_address.getText().toString(),
                        et_content.getText().toString());
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void addCompanyPositionSuccess() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void addCompanyPositionFail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("添加职位失败")
                .setPositiveButton("取消", null).show();
    }

    @Override
    public void getCompanyPositionSuccess(CompanyPosition.DataBean data) {
        et_name.setText(data.getPosition());
        et_type.setText(data.getWorkingtype());
        et_education.setText(data.getEducation());
        et_number.setText(data.getNumber());
        et_startwages.setText(data.getWagesstart());
        et_endwages.setText(data.getWagesend());
        et_startworktime.setText(data.getWorkingyearstart());
        et_endworktime.setText(data.getWorkingyearend());
        et_city.setText(data.getWorkplace());
        et_address.setText(data.getAddress());
        et_content.setText(data.getContent());
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
