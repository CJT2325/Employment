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
import com.cjt.employment.adapter.ExploreAdapter;
import com.cjt.employment.adapter.MessageAdapter;
import com.cjt.employment.bean.InformationBean;
import com.cjt.employment.bean.UserBean;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.ExplorePresenter;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends BaseFragment<ExploreFragment, ExplorePresenter> implements ExploreView{
    private RecyclerView mRecyclerView;
    private List<InformationBean.DataBean> mDatas;
    private ExploreAdapter mExploreAdapter;
    private ProgressBar progressBar;

    public static ExploreFragment newInstance() {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public ExploreFragment() {

    }

    @Override
    protected ExplorePresenter creatPresenter() {
        return new ExplorePresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        initDatas();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_explore);
        progressBar= (ProgressBar) view.findViewById(R.id.progressbar);
        mExploreAdapter = new ExploreAdapter(mDatas, getActivity(), new ExploreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mExploreAdapter.statrInfomationActivity(position);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mExploreAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        getPresenter().getInfomation("getInfomation");
        return view;
    }
    private void initDatas() {
        mDatas = new ArrayList<InformationBean.DataBean>();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getPresenter() != null) {
//            getPresenter().getInfomation("getInfomation");
            Log.i("CJT","======================================");
        } else {
            Log.i("CJT", "presenter is null");
        }
    }

    @Override
    public void updateInfomation(List<InformationBean.DataBean> data) {
        mExploreAdapter.updata(data);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}