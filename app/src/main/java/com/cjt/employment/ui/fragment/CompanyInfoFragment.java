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
import com.cjt.employment.adapter.MessageAdapter;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.ui.presenter.CompanyInfoPresenter;
import com.cjt.employment.ui.presenter.HomePresenter;
import com.cjt.employment.ui.presenter.MessagePresenter;

import java.util.ArrayList;

public class CompanyInfoFragment extends BaseFragment<CompanyInfoFragment, CompanyInfoPresenter> {
    public static CompanyInfoFragment newInstance() {
        CompanyInfoFragment fragment = new CompanyInfoFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public CompanyInfoFragment() {

    }

    @Override
    protected CompanyInfoPresenter creatPresenter() {
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
//        initDatas();
        return view;
    }

    private void initDatas() {
//        mDatas = new ArrayList<String>();
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
