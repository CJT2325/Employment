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
import com.cjt.employment.adapter.MessageAdapter;
import com.cjt.employment.adapter.UserVitageAdapter;
import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.common.Config;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.InterviewVitagePresenter;
import com.cjt.employment.presenter.MessagePresenter;
import com.cjt.employment.presenter.UntreatedVitagePresenter;
import com.cjt.employment.ui.view.AllVitageView;

import java.util.ArrayList;
import java.util.List;

public class InterviewVitageFragment extends BaseFragment<InterviewVitageFragment,InterviewVitagePresenter>  implements AllVitageView {
    private ProgressBar progressbar;
    private RecyclerView mRecyclerView;
    private List<UserVitage.DataBean> mDatas;
    private UserVitageAdapter mUserVitageAdapter;

    public static InterviewVitageFragment newInstance() {
        InterviewVitageFragment fragment = new InterviewVitageFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public InterviewVitageFragment() {

    }

    @Override
    protected InterviewVitagePresenter creatPresenter() {
        Log.i("CJT","创建UntreatedVitageFragment");
        return new InterviewVitagePresenter(this);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_interview_vitage, container, false);
        initDatas();
        initView(view);
//        getPresenter().getRecruit("getAllUserVitage", Config.getValueByKey(getContext(),Config.KEY_USERID));
        return view;
    }

    private void initView(View view) {
        progressbar= (ProgressBar) view.findViewById(R.id.progressbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_vitage);
        mUserVitageAdapter = new UserVitageAdapter(mDatas, getActivity(), new UserVitageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mUserVitageAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
    }


    private void initDatas() {
        mDatas = new ArrayList<UserVitage.DataBean>();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("CJT","AllUserVitage Start");
        if (getPresenter() != null) {
            getPresenter().getRecruit("getAllUserVitage", Config.getValueByKey(getContext(),Config.KEY_USERID),"2");
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
    public void getAllVitageSuccess(List<UserVitage.DataBean> datas) {
        mUserVitageAdapter.updata(datas);
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