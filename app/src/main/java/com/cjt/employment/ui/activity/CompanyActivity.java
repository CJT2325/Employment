package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cjt.employment.R;
import com.cjt.employment.adapter.CompanyTabAdapter;
import com.cjt.employment.ui.fragment.CompanyInfoFragment;
import com.cjt.employment.ui.fragment.PositionFragment;

import java.util.ArrayList;
import java.util.List;

public class CompanyActivity extends AppCompatActivity {
    private TabLayout tl_company;
    private ViewPager vp_info;
    private List<Fragment> list_fragment;
    private List<String> list_title;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private CompanyInfoFragment mCompanyInfoFragment;
    private PositionFragment mPositionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        tl_company = (TabLayout) findViewById(R.id.tl_company);
        vp_info = (ViewPager) findViewById(R.id.vp_info);
        //初始化Fragment
        list_fragment = new ArrayList<Fragment>();
        mCompanyInfoFragment = CompanyInfoFragment.newInstance();
        mPositionFragment = PositionFragment.newInstance();
        list_fragment.add(mCompanyInfoFragment);
        list_fragment.add(mPositionFragment);
        //初始化标题
        list_title = new ArrayList<String>();
        list_title.add("公司主页");
        list_title.add("招聘职位");

        tl_company.setTabMode(TabLayout.MODE_FIXED);
        tl_company.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < list_title.size(); i++) {
            tl_company.addTab(tl_company.newTab().setText(list_title.get(i)));
        }
        mFragmentPagerAdapter = new CompanyTabAdapter(getSupportFragmentManager(), list_fragment, list_title);
        vp_info.setAdapter(mFragmentPagerAdapter);
        tl_company.setupWithViewPager(vp_info);
    }
}
