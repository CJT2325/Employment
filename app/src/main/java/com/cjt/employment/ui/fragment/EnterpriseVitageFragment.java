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
import com.cjt.employment.presenter.EnterprisePositionPresenter;
import com.cjt.employment.presenter.EnterpriseVitagePresenter;
import com.cjt.employment.ui.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseVitageFragment extends BaseFragment<EnterpriseVitageFragment, EnterpriseVitagePresenter> implements HomeView {
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private List<Recruit.DataBean> mDatas;
    private RecruitmentAdapter mRecruitmentAdapter;

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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initDatas();
        initView(view);
//        getPresenter().getPositionByCompanyId("getPositionByCompanyId",);
        showProgressBar();
        return view;
    }

    private void initView(View view) {
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_recruitment);
        mRecruitmentAdapter = new RecruitmentAdapter(mDatas, getActivity(), new RecruitmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Intent recruitmentInfoIntent = new Intent(getContext(), RecruitmentInfoActivity.class);
//                startActivity(recruitmentInfoIntent);
                mRecruitmentAdapter.startActivityByRecruitId(position);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecruitmentAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
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
    public void updateRecruit(List<Recruit.DataBean> data) {
        mRecruitmentAdapter.updataRecruit(data);
        hideProgressBar();
    }

    @Override
    public void updateMoreRecruit(List<Recruit.DataBean> data) {

    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}