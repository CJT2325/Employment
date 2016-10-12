package com.cjt.employment.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cjt.employment.R;
import com.cjt.employment.adapter.RecruitmentAdapter;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.EnterpriseInfoPresenter;
import com.cjt.employment.presenter.EnterpriseVitagePresenter;
import com.cjt.employment.ui.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseInfoFragment extends BaseFragment<EnterpriseInfoFragment, EnterpriseInfoPresenter> implements HomeView {
    public static EnterpriseInfoFragment newInstance() {
        EnterpriseInfoFragment fragment = new EnterpriseInfoFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public EnterpriseInfoFragment() {

    }

    @Override
    protected EnterpriseInfoPresenter creatPresenter() {
        return new EnterpriseInfoPresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_enterprise_info, container, false);
        initView(view);
//        getPresenter().getPositionByCompanyId("getPositionByCompanyId",);

        return view;
    }

    private void initView(View view) {

    }

    @Override
    public void onStart() {
        super.onStart();
        if (getPresenter() != null) {
//            getPresenter().getShopList();
        } else {
            Log.i("CJT", "presenter is null");
        }
    }


    @Override
    public void updateRecruit(List<Recruit.DataBean> data) {
        hideProgressBar();
    }

    @Override
    public void updateMoreRecruit(List<Recruit.DataBean> data) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

}