package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.adapter.AdapterForLinearLayout;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.HopeJob;
import com.cjt.employment.bean.Project;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.common.Config;
import com.cjt.employment.presenter.VitagePresenter;
import com.cjt.employment.ui.view.VitageView;
import com.cjt.employment.view.LinearLayoutForListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VitaeActivity extends BaseActivity<VitaeActivity, VitagePresenter> implements View.OnClickListener, VitageView {

    private RelativeLayout layout_user_unedit;
    private RelativeLayout layout_user_edit;

    private RelativeLayout layout_worklist_unedit;
    private RelativeLayout layout_worklist_edit;

    private RelativeLayout layout_education_unedit;
    private RelativeLayout layout_education_edit;

    private RelativeLayout layout_project_unedit;
    private RelativeLayout layout_project_edit;

    private RelativeLayout layout_hopejob_unedit;
    private RelativeLayout layout_hopejob_edit;

    private CircleImageView iv_cover;
    private RelativeLayout photo_bottomsheet;
    private BottomSheetDialog dialog;
    private RelativeLayout bs_photograph;
    private RelativeLayout bs_album;
    private RelativeLayout bs_cancel;

    private LinearLayoutForListView worklistview;
    private LinearLayoutForListView educationlistview;
    private LinearLayoutForListView projectlistview;
    private AdapterForLinearLayout worklistviewAdpater;
    private AdapterForLinearLayout educationlistviewAdpater;
    private AdapterForLinearLayout projectlistviewAdpater;

    //基本信息
    private TextView tv_name;
    private TextView tv_sex;
    private TextView tv_brithday;
    private TextView tv_education;
    private TextView tv_worktime;
    private TextView tv_phone;
    private TextView tv_email;
    private TextView tv_city;

    //期望工作
    private TextView tv_hopeposition;
    private TextView tv_jobtype;
    private TextView tv_content;

    private TextView tv_workexperience_edit;
    private TextView tv_education_edit;
    private TextView tv_hopejob_edit;
    private TextView tv_project_edit;

    public final static int requestCode = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitae);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("在线简历");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getVitageUser("getVitageUser", Config.getValueByKey(this, Config.KEY_USERID));
        getPresenter().getWorkExperienceList("getWorkExperienceList", Config.getValueByKey(this, Config.KEY_USERID));
        getPresenter().getEducationList("getEducationList", Config.getValueByKey(this, Config.KEY_USERID));
        getPresenter().getHopeJob("getHopeJob", Config.getValueByKey(this, Config.KEY_USERID));
        getPresenter().getProjectList("getProjectList", Config.getValueByKey(this, Config.KEY_USERID));
    }

    private void initView() {
        //更换头像
        photo_bottomsheet = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.photo_bottomsheet, null);
        dialog = new BottomSheetDialog(this);
        dialog.setContentView(photo_bottomsheet);
        iv_cover = (CircleImageView) findViewById(R.id.iv_cover);
        iv_cover.setOnClickListener(this);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_brithday = (TextView) findViewById(R.id.tv_brithday);
        tv_education = (TextView) findViewById(R.id.tv_education);
        tv_worktime = (TextView) findViewById(R.id.tv_worktime);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_city = (TextView) findViewById(R.id.tv_city);

        tv_hopeposition = (TextView) findViewById(R.id.tv_hopeposition);
        tv_jobtype = (TextView) findViewById(R.id.tv_jobtype);
        tv_content = (TextView) findViewById(R.id.tv_content);

        //简历个人信息
        layout_user_unedit = (RelativeLayout) findViewById(R.id.layout_user_unedit);
        layout_user_edit = (RelativeLayout) findViewById(R.id.layout_user_edit);
        layout_user_unedit.setOnClickListener(this);
        layout_user_edit.setOnClickListener(this);
        layout_user_unedit.setVisibility(View.VISIBLE);
        layout_user_edit.setVisibility(View.GONE);

        layout_worklist_unedit = (RelativeLayout) findViewById(R.id.layout_worklist_unedit);
        layout_worklist_edit = (RelativeLayout) findViewById(R.id.layout_worklist_edit);
        layout_worklist_unedit.setOnClickListener(this);
        layout_worklist_edit.setOnClickListener(this);
        layout_worklist_unedit.setVisibility(View.VISIBLE);
        layout_worklist_edit.setVisibility(View.GONE);

        layout_education_unedit = (RelativeLayout) findViewById(R.id.layout_education_unedit);
        layout_education_edit = (RelativeLayout) findViewById(R.id.layout_education_edit);
        layout_education_unedit.setOnClickListener(this);
        layout_education_edit.setOnClickListener(this);
        layout_education_unedit.setVisibility(View.VISIBLE);
        layout_education_edit.setVisibility(View.GONE);


        layout_project_unedit = (RelativeLayout) findViewById(R.id.layout_project_unedit);
        layout_project_edit = (RelativeLayout) findViewById(R.id.layout_project_edit);
        layout_project_unedit.setOnClickListener(this);
        layout_project_edit.setOnClickListener(this);
        layout_project_unedit.setVisibility(View.VISIBLE);
        layout_project_edit.setVisibility(View.GONE);


        //希望的工作
        layout_hopejob_unedit = (RelativeLayout) findViewById(R.id.layout_hopejob_unedit);
        layout_hopejob_edit = (RelativeLayout) findViewById(R.id.layout_hopejob_edit);
        layout_hopejob_unedit.setOnClickListener(this);
        layout_hopejob_edit.setOnClickListener(this);
        layout_hopejob_unedit.setVisibility(View.VISIBLE);
        layout_hopejob_edit.setVisibility(View.GONE);
        layout_hopejob_unedit.setOnClickListener(this);


        worklistview = (LinearLayoutForListView) findViewById(R.id.layout_worklistview);
        educationlistview = (LinearLayoutForListView) findViewById(R.id.layout_educationlistview);
        projectlistview = (LinearLayoutForListView) findViewById(R.id.layout_projectlistview);
        getData();

        //编辑按钮
        tv_workexperience_edit = (TextView) findViewById(R.id.tv_workexperience_edit);
        tv_education_edit = (TextView) findViewById(R.id.tv_education_edit);
        tv_hopejob_edit = (TextView) findViewById(R.id.tv_hopejob_edit);
        tv_project_edit = (TextView) findViewById(R.id.tv_project_edit);
        tv_workexperience_edit.setOnClickListener(this);
        tv_education_edit.setOnClickListener(this);
        tv_hopejob_edit.setOnClickListener(this);
        tv_project_edit.setOnClickListener(this);
    }

    private void getData() {

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> win = new HashMap<String, Object>();
            win.put("worktime", "2016.09-2016.10");
            win.put("workname", "某某科技有限公司/Android");
            win.put("workcontent", "工作内容: 工作内容工作内容工作内容工作内容工作内容工作内容");
            list.add(win);
        }

        ArrayList<HashMap<String, Object>> list2 = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> win = new HashMap<String, Object>();
            win.put("projecttime", "  2016.09-2016.10");
            win.put("projectname", "【项目名称】 美团外卖");
            win.put("projectreponsibility", "【项目职责】 WorkContent");
            win.put("projectcontent", "  项目描述: WorkContent");
            list2.add(win);
        }

        worklistviewAdpater = new AdapterForLinearLayout(this, list, R.layout.worklist_item, new String[]{"worktime", "workname", "workcontent"},
                new int[]{R.id.tv_worktime, R.id.tv_workname, R.id.tv_workcontent});
        worklistview.setAdapter(worklistviewAdpater);

        educationlistviewAdpater = new AdapterForLinearLayout(this, list, R.layout.worklist_item, new String[]{"worktime", "workname", "workcontent"},
                new int[]{R.id.tv_worktime, R.id.tv_workname, R.id.tv_workcontent});
        educationlistview.setAdapter(educationlistviewAdpater);

        projectlistviewAdpater = new AdapterForLinearLayout(this, list2, R.layout.projectlist_item, new String[]{"projecttime", "projectname", "projectreponsibility", "projectcontent"},
                new int[]{R.id.tv_projecttime, R.id.tv_projectname, R.id.tv_projectreponsibility, R.id.tv_projectcontent});
        projectlistview.setAdapter(projectlistviewAdpater);
    }

    @Override
    protected VitagePresenter creatPresenter() {
        return new VitagePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_cover:
                dialog.show();
                break;
            case R.id.layout_user_unedit:
                Intent editIntent = new Intent(this, VitageUserEditActivity.class);
                startActivityForResult(editIntent, requestCode);
                break;
            case R.id.layout_worklist_unedit:
                Intent worklistUneditIntent = new Intent(this, WorkExperienceActivity.class);
                startActivityForResult(worklistUneditIntent, requestCode);
                break;
            case R.id.layout_education_unedit:
                Intent educationUneditIntent = new Intent(this, EducationActivity.class);
                startActivityForResult(educationUneditIntent, requestCode);
                break;
            case R.id.layout_project_unedit:
                Intent projectUneditIntent = new Intent(this, ProjectActivity.class);
                startActivityForResult(projectUneditIntent, requestCode);
                break;
            case R.id.layout_hopejob_unedit:
                Intent hopJobEditIntent = new Intent(this, HopeJobEditActivity.class);
                startActivity(hopJobEditIntent);
                break;
            case R.id.layout_user_edit:
                break;
            case R.id.tv_workexperience_edit:
                Intent workExperienceIntent = new Intent(this, WorkExperienceActivity.class);
                startActivity(workExperienceIntent);
                break;
            case R.id.tv_education_edit:
                Intent educationIntent = new Intent(this, EducationActivity.class);
                startActivity(educationIntent);
                break;
            case R.id.tv_hopejob_edit:
                Intent hopejobIntent = new Intent(this, HopeJobEditActivity.class);
                startActivity(hopejobIntent);
                break;
            case R.id.tv_project_edit:
                Intent projectIntent = new Intent(this, ProjectActivity.class);
                startActivity(projectIntent);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VitaeActivity.requestCode && resultCode == 1) {
            layout_user_unedit.setVisibility(View.GONE);
            layout_user_edit.setVisibility(View.VISIBLE);
            tv_name.setText("姓        名:  " + data.getStringExtra("name"));
            tv_sex.setText("性        别:  " + data.getStringExtra("sex"));
            tv_brithday.setText("出生年份:  " + data.getStringExtra("brithday"));
            tv_education.setText("最高学历:  " + data.getStringExtra("education"));
            tv_worktime.setText("工作年限:  " + data.getStringExtra("worktime"));
            tv_phone.setText("联系电话:  " + data.getStringExtra("phone"));
            tv_email.setText("联系邮箱:  " + data.getStringExtra("email"));
            tv_city.setText("所在城市:  " + data.getStringExtra("city"));
        }
    }

    @Override
    public void getWorkExperienceSuccess(List<WorkExperience.DataBean> data) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < data.size(); i++) {
            WorkExperience.DataBean dataBean = data.get(i);
            HashMap<String, Object> win = new HashMap<String, Object>();
            win.put("worktime", dataBean.getStarttime() + " - " + dataBean.getEndtime());
            win.put("workname", dataBean.getCompanyname() + "/" + dataBean.getPosition());
            win.put("workcontent", dataBean.getContent());
            list.add(win);
        }
        worklistviewAdpater = new AdapterForLinearLayout(this, list, R.layout.worklist_item, new String[]{"worktime", "workname", "workcontent"},
                new int[]{R.id.tv_worktime, R.id.tv_workname, R.id.tv_workcontent});
        worklistview.removeAllViews();
        worklistview.setAdapter(worklistviewAdpater);
        if (data.size() > 0) {
            layout_worklist_unedit.setVisibility(View.GONE);
            layout_worklist_edit.setVisibility(View.VISIBLE);
        }
//        worklistviewAdpater.update(list);
    }

    @Override
    public void getEducationSuccess(List<Education.DataBean> data) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < data.size(); i++) {
            Education.DataBean dataBean = data.get(i);
            HashMap<String, Object> win = new HashMap<String, Object>();
            win.put("worktime", dataBean.getGraduationtime() + "年毕业");
            win.put("workname", dataBean.getSchool());
            win.put("workcontent", dataBean.getEducation() + " - " + dataBean.getMajor());
            list.add(win);
        }
        educationlistviewAdpater = new AdapterForLinearLayout(this, list, R.layout.worklist_item, new String[]{"worktime", "workname", "workcontent"},
                new int[]{R.id.tv_worktime, R.id.tv_workname, R.id.tv_workcontent});
        educationlistview.removeAllViews();
        educationlistview.setAdapter(educationlistviewAdpater);

        if (data.size() > 0) {
            layout_education_unedit.setVisibility(View.GONE);
            layout_education_edit.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getHopeJobSuccess(HopeJob.DataBean data) {
        tv_hopeposition.setText(data.getHopeposition());
        tv_jobtype.setText(data.getJobtype() + "/" + data.getCity() + "/" + data.getMoney());
        tv_content.setText(data.getContent());
        if (!data.getHopeposition().equals("")) {
            layout_hopejob_unedit.setVisibility(View.GONE);
            layout_hopejob_edit.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getProjectSuccess(List<Project.DataBean> data) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < data.size(); i++) {
            Project.DataBean dataBean = data.get(i);
            HashMap<String, Object> win = new HashMap<String, Object>();
            win.put("projecttime", "  " + dataBean.getStarttime() + " - " + dataBean.getEndtime());
            win.put("projectname", "【项目名称】 " + dataBean.getName());
            win.put("projectreponsibility", "【项目职责】 " + dataBean.getResponsibility());
            win.put("projectcontent", "  项目描述: " + dataBean.getContent());
            list.add(win);
        }
        projectlistviewAdpater = new AdapterForLinearLayout(this, list, R.layout.projectlist_item, new String[]{"projecttime", "projectname", "projectreponsibility", "projectcontent"},
                new int[]{R.id.tv_projecttime, R.id.tv_projectname, R.id.tv_projectreponsibility, R.id.tv_projectcontent});
        projectlistview.removeAllViews();
        projectlistview.setAdapter(projectlistviewAdpater);
        if (data.size() > 0) {
            layout_project_unedit.setVisibility(View.GONE);
            layout_project_edit.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getVitageSuccess(VitageBean.DataBean data) {
        layout_user_unedit.setVisibility(View.GONE);
        layout_user_edit.setVisibility(View.VISIBLE);
        tv_name.setText("姓        名:  " + data.getName());
        tv_sex.setText("性        别:  " + data.getSex());
        tv_brithday.setText("出生年份:  " + data.getBrithday());
        tv_education.setText("最高学历:  " + data.getEducation());
        tv_worktime.setText("工作年限:  " + data.getWorktime());
        tv_phone.setText("联系电话:  " + data.getPhone());
        tv_email.setText("联系邮箱:  " + data.getEmail());
        tv_city.setText("所在城市:  " + data.getCity());

    }


    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
