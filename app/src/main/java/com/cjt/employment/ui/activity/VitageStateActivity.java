package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.cjt.employment.R;
import com.cjt.employment.adapter.CompanyTabAdapter;
import com.cjt.employment.ui.fragment.AllVitageFragment;
import com.cjt.employment.ui.fragment.AllVitageStateFragment;
import com.cjt.employment.ui.fragment.InappropriateVitageFragment;
import com.cjt.employment.ui.fragment.InappropriateVitageStateFragment;
import com.cjt.employment.ui.fragment.InterviewVitageFragment;
import com.cjt.employment.ui.fragment.InterviewVitageStateFragment;
import com.cjt.employment.ui.fragment.LookVitageStateFragment;
import com.cjt.employment.ui.fragment.UntreatedVitageFragment;
import com.cjt.employment.ui.fragment.UntreatedVitageStateFragment;

import java.util.ArrayList;
import java.util.List;

public class VitageStateActivity extends AppCompatActivity {
    private TabLayout tl_vitage;
    private ViewPager vp_info;


    private List<Fragment> list_fragment;
    private List<String> list_title;

    private FragmentPagerAdapter mFragmentPagerAdapter;

    private AllVitageStateFragment allVitageStateFragment;
    private UntreatedVitageStateFragment untreatedVitageStateFragment;
    private LookVitageStateFragment lookVitageStateFragment;
    private InterviewVitageStateFragment interviewVitageStateFragment;
    private InappropriateVitageStateFragment inappropriateVitageStateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitage_state);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("简历状态");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        tl_vitage = (TabLayout) findViewById(R.id.tl_vitage);
        vp_info = (ViewPager) findViewById(R.id.vp_info);
    }


    @Override
    public void onStart() {
        Log.i("CJT", "################## EnterpriseVitageFragment Start! ##################");
        //初始化Fragment
        list_fragment = new ArrayList<Fragment>();

        allVitageStateFragment = AllVitageStateFragment.newInstance();
        untreatedVitageStateFragment = UntreatedVitageStateFragment.newInstance();
        lookVitageStateFragment=LookVitageStateFragment.newInstance();
        interviewVitageStateFragment = InterviewVitageStateFragment.newInstance();
        inappropriateVitageStateFragment = InappropriateVitageStateFragment.newInstance();

        list_fragment.add(allVitageStateFragment);
        list_fragment.add(untreatedVitageStateFragment);
        list_fragment.add(lookVitageStateFragment);
        list_fragment.add(interviewVitageStateFragment);
        list_fragment.add(inappropriateVitageStateFragment);
        //初始化标题
        list_title = new ArrayList<String>();
        list_title.add("全部");
        list_title.add("未处理");
        list_title.add("被查看");
        list_title.add("待面试");
        list_title.add("不合适");

        tl_vitage.setTabMode(TabLayout.MODE_FIXED);
        tl_vitage.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < list_title.size(); i++) {
            tl_vitage.addTab(tl_vitage.newTab().setText(list_title.get(i)));
        }
        mFragmentPagerAdapter = new CompanyTabAdapter(getSupportFragmentManager(), list_fragment, list_title);
        vp_info.setAdapter(mFragmentPagerAdapter);
        tl_vitage.setupWithViewPager(vp_info);
        super.onStart();
    }
}
