package com.cjt.employment.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.cjt.employment.ui.presenter.ExplorePresenter;
import com.cjt.employment.ui.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends BaseFragment<HomeFragment, ExplorePresenter> {

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
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        return view;
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