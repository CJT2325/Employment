package com.cjt.employment.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cjt.employment.R;
import com.cjt.employment.ui.activity.EvaluateActivity;
import com.cjt.employment.ui.presenter.CompanyInfoPresenter;


public class CompanyInfoFragment extends BaseFragment<CompanyInfoFragment, CompanyInfoPresenter> implements View.OnClickListener {
    private RelativeLayout layout_evaluate;

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
        View view = inflater.inflate(R.layout.fragment_company_info, container, false);
        layout_evaluate= (RelativeLayout) view.findViewById(R.id.layout_evaluate);
        layout_evaluate.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_evaluate:
                Intent evaluateIntent=new Intent(getContext(),EvaluateActivity.class);
                startActivity(evaluateIntent);
                break;
        }
    }
}
