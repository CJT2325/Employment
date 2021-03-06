package com.cjt.employment.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cjt.employment.R;
import com.cjt.employment.adapter.EnterprisePositionAdapter;
import com.cjt.employment.adapter.RecruitmentAdapter;
import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.common.Config;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.EnterprisePositionPresenter;
import com.cjt.employment.presenter.HomePresenter;
import com.cjt.employment.ui.activity.EditCompanyPositionActivity;
import com.cjt.employment.ui.view.EnterprisePositionView;
import com.cjt.employment.ui.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class EnterprisePositionFragment extends BaseFragment<EnterprisePositionFragment, EnterprisePositionPresenter> implements EnterprisePositionView, View.OnClickListener {
    public final static int ADD_COMPANYPOSITION_CODE = 1;

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private List<EnterprisePosition.DataBean> mDatas;
    private EnterprisePositionAdapter mEnterprisePositionAdapter;

    private FloatingActionButton fab;

    public static EnterprisePositionFragment newInstance() {
        EnterprisePositionFragment fragment = new EnterprisePositionFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public EnterprisePositionFragment() {

    }

    @Override
    protected EnterprisePositionPresenter creatPresenter() {
        return new EnterprisePositionPresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_enterprise_position, container, false);
        initDatas();
        initView(view);
        getPresenter().getPositionByCompanyId("getPositionByCompanyId", Config.getValueByKey(getContext(), Config.KEY_USERID));
        return view;
    }

    private void initView(View view) {
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_positon);
        mEnterprisePositionAdapter = new EnterprisePositionAdapter(mDatas, getActivity(), new EnterprisePositionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mEnterprisePositionAdapter.startActivityByRecruitId(position);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mEnterprisePositionAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
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
    public void getEnterprisePositionSuccess(List<EnterprisePosition.DataBean> datas) {
        mEnterprisePositionAdapter.updataRecruit(datas);
    }

    @Override
    public void getEnterprisePositionFail() {

    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Intent editCompanyPositionIntent = new Intent(getContext(), EditCompanyPositionActivity.class);
                startActivityForResult(editCompanyPositionIntent, ADD_COMPANYPOSITION_CODE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == ADD_COMPANYPOSITION_CODE) {
                getPresenter().getPositionByCompanyId("getPositionByCompanyId", Config.getValueByKey(getContext(), Config.KEY_USERID));
            }
        }
    }
}