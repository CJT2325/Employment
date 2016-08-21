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
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.PositionPresenter;

import java.util.ArrayList;
import java.util.List;

public class PositionFragment extends BaseFragment<PositionFragment, PositionPresenter> {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private PositionAdapter mPositionAdapter;

    public static PositionFragment newInstance() {
        PositionFragment fragment = new PositionFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public PositionFragment() {

    }

    @Override
    protected PositionPresenter creatPresenter() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_position, container, false);
        initDatas();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_position);
        mPositionAdapter = new PositionAdapter(mDatas, getActivity(), new PositionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mPositionAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        return view;
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
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
