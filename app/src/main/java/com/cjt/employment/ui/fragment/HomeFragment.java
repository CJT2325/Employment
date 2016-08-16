package com.cjt.employment.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjt.employment.R;
import com.cjt.employment.adapter.RecruitmentAdapter;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.ui.activity.RecruitmentInfoActivity;
import com.cjt.employment.ui.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomeFragment, HomePresenter> {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private RecruitmentAdapter mRecruitmentAdapter;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {

    }

    @Override
    protected HomePresenter creatPresenter() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initDatas();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_recruitment);
        mRecruitmentAdapter = new RecruitmentAdapter(mDatas, getActivity(), new RecruitmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent recruitmentInfoIntent =new Intent(getContext(), RecruitmentInfoActivity.class);
                startActivity(recruitmentInfoIntent);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecruitmentAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
//        this.mPresenter = creatPresenter();
        return view;
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            mDatas.add("Stirng " + i);
        }
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
}