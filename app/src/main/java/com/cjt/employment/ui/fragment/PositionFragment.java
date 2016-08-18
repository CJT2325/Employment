package com.cjt.employment.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjt.employment.R;
import com.cjt.employment.ui.presenter.CompanyInfoPresenter;
import com.cjt.employment.ui.presenter.PositionPresenter;

public class PositionFragment extends BaseFragment<PositionFragment, PositionPresenter> {
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
