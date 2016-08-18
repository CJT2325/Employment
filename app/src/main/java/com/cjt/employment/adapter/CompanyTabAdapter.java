package com.cjt.employment.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/6/16
 * 邮箱: 445263848@qq.com.
 */
public class CompanyTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;
    private List<String> list_title;

    public CompanyTabAdapter(FragmentManager fm, List<Fragment> list_fragment, List<String> list_title) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list_title = list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position % list_title.size());
    }
}
