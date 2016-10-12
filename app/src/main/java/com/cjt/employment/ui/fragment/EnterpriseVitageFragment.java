package com.cjt.employment.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cjt.employment.R;
import com.cjt.employment.adapter.CompanyTabAdapter;
import com.cjt.employment.adapter.RecruitmentAdapter;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.EnterprisePositionPresenter;
import com.cjt.employment.presenter.EnterpriseVitagePresenter;
import com.cjt.employment.ui.view.EnterpriseVitageView;
import com.cjt.employment.ui.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseVitageFragment extends BaseFragment<EnterpriseVitageFragment, EnterpriseVitagePresenter> implements EnterpriseVitageView {
    private TabLayout tl_vitage;
    private ViewPager vp_info;


    private List<Fragment> list_fragment;
    private List<String> list_title;

    private FragmentPagerAdapter mFragmentPagerAdapter;

    private AllVitageFragment allVitageFragment;
    private UntreatedVitageFragment untreatedVitageFragment;
    private InterviewVitageFragment interviewVitageFragment;
    private InappropriateVitageFragment inappropriateVitageFragment;

    public static EnterpriseVitageFragment newInstance() {
        EnterpriseVitageFragment fragment = new EnterpriseVitageFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public EnterpriseVitageFragment() {

    }

    @Override
    protected EnterpriseVitagePresenter creatPresenter() {
        return new EnterpriseVitagePresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_enterprise_vitage, container, false);
        initView(view);
//        getPresenter().getPositionByCompanyId("getPositionByCompanyId",);
        return view;
    }

    private void initView(View view) {
        tl_vitage = (TabLayout) view.findViewById(R.id.tl_vitage);
        vp_info = (ViewPager) view.findViewById(R.id.vp_info);

        //初始化Fragment
        list_fragment = new ArrayList<Fragment>();
        allVitageFragment = AllVitageFragment.newInstance();
        untreatedVitageFragment = UntreatedVitageFragment.newInstance();
        interviewVitageFragment = InterviewVitageFragment.newInstance().newInstance();
        inappropriateVitageFragment = InappropriateVitageFragment.newInstance();

        list_fragment.add(allVitageFragment);
        list_fragment.add(untreatedVitageFragment);
        list_fragment.add(interviewVitageFragment);
        list_fragment.add(inappropriateVitageFragment);
        //初始化标题
        list_title = new ArrayList<String>();
        list_title.add("全部");
        list_title.add("未处理");
        list_title.add("待面试");
        list_title.add("不合适");

        tl_vitage.setTabMode(TabLayout.MODE_FIXED);
        tl_vitage.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < list_title.size(); i++) {
            tl_vitage.addTab(tl_vitage.newTab().setText(list_title.get(i)));
        }
        mFragmentPagerAdapter = new CompanyTabAdapter(getActivity().getSupportFragmentManager(), list_fragment, list_title);
        vp_info.setAdapter(mFragmentPagerAdapter);
        tl_vitage.setupWithViewPager(vp_info);
    }


    @Override
    public void onStart() {
        super.onStart();

    }
}