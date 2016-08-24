package com.cjt.employment.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjt.employment.R;
import com.cjt.employment.adapter.PositionAdapter;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.PositionPresenter;
import com.cjt.employment.ui.view.PositionView;

import java.util.ArrayList;
import java.util.List;

public class PositionFragment extends BaseFragment<PositionFragment, PositionPresenter> implements PositionView {
    private RecyclerView mRecyclerView;
    private List<Recruit.DataBean> mDatas;
    private PositionAdapter mPositionAdapter;

    public static PositionFragment newInstance(int id) {
        PositionFragment fragment = new PositionFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        return fragment;
    }

    public PositionFragment() {

    }

    @Override
    protected PositionPresenter creatPresenter() {
        return new PositionPresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_position, container, false);
        initDatas();
        initView(view);
        if (getPresenter() != null) {
            getPresenter().getRecruitInfoByCompanyId("getRecruitByCompanyId",getArguments().getInt("id"));
        } else {
            Log.i("CJT", "presenter is null");
        }
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_position);
        mPositionAdapter = new PositionAdapter(mDatas, getActivity(), new PositionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mPositionAdapter.startActivityByRecruitId(position);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mPositionAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
    }

    private void initDatas() {
        mDatas = new ArrayList<Recruit.DataBean>();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void updatePositionInfo(List<Recruit.DataBean> data) {
        mPositionAdapter.updata(data);
    }
}
