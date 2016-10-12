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
import com.cjt.employment.adapter.MessageAdapter;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.MessagePresenter;

import java.util.ArrayList;
import java.util.List;

public class InappropriateVitageFragment extends BaseFragment<HomeFragment, MessagePresenter> {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private MessageAdapter mMessageAdapter;

    public static InappropriateVitageFragment newInstance() {
        InappropriateVitageFragment fragment = new InappropriateVitageFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public InappropriateVitageFragment() {

    }

    @Override
    protected MessagePresenter creatPresenter() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        initDatas();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_message);
        mMessageAdapter = new MessageAdapter(mDatas, getActivity(), new MessageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mMessageAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        return view;
    }
    private void initDatas() {
        mDatas = new ArrayList<String>();
//        for (int i = 0; i < 4; i++) {
//            mDatas.add("Stirng " + i);
//        }
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