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
import com.cjt.employment.adapter.VitageStateAdapter;
import com.cjt.employment.bean.VitageStateBean;
import com.cjt.employment.common.Config;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.AllVitageStatePresenter;
import com.cjt.employment.presenter.InterviewVitageStatePresenter;
import com.cjt.employment.ui.view.AllVitageStateView;

import java.util.ArrayList;
import java.util.List;

public class InterviewVitageStateFragment extends BaseFragment<InterviewVitageStateFragment, InterviewVitageStatePresenter> implements AllVitageStateView {
    private ProgressBar progressbar;
    private RecyclerView mRecyclerView;
    private List<VitageStateBean.DataBean> mDatas;
    private VitageStateAdapter mVitageStateAdapter;

    public static InterviewVitageStateFragment newInstance() {
        InterviewVitageStateFragment fragment = new InterviewVitageStateFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public InterviewVitageStateFragment() {

    }

    @Override
    protected InterviewVitageStatePresenter creatPresenter() {
        Log.i("CJT","创建AllVitagePresenter");
        return new InterviewVitageStatePresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_all_vitage_state, container, false);
        initDatas();
        initView(view);
//        getPresenter().getRecruit("getAllUserVitage", Config.getValueByKey(getContext(),Config.KEY_USERID));
        return view;
    }

    private void initView(View view) {
        progressbar= (ProgressBar) view.findViewById(R.id.progressbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_vitage);
        mVitageStateAdapter = new VitageStateAdapter(mDatas, getActivity(), new VitageStateAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mVitageStateAdapter.startActivityByRecruitId(position);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mVitageStateAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
    }


    private void initDatas() {
        mDatas = new ArrayList<VitageStateBean.DataBean>();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("CJT","AllUserVitage Start");
        if (getPresenter() != null) {
            getPresenter().getAllStateVitage("getAllStateVitage", Config.getValueByKey(getContext(),Config.KEY_USERID),"2");
            Log.i("CJT","getAllUserVitage");
        } else {
            Log.i("CJT", "AllVitagePresenter is null");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("CJT","AllUserVitage Stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("CJT","AllUserVitage onDestroy");
    }

    @Override
    public void getAllVitageStateSuccess(List<VitageStateBean.DataBean> datas) {
        mVitageStateAdapter.updata(datas);
    }

    @Override
    public void showProgressBar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressbar.setVisibility(View.GONE);
    }
}