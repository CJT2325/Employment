package com.cjt.employment.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjt.employment.presenter.BasePresenter;

/**
 * 作者: 陈嘉桐 on 2016/7/1
 * 邮箱: 445263848@qq.com.
 */
public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPresenter = creatPresenter();
        mPresenter.onViewCreate();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("BaseActivity", "BaseActivity onStart");
        if (mPresenter!=null) {
            mPresenter.onViewStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("BaseActivity", "BaseActivity onResume");
        if (mPresenter!=null) {
            mPresenter.onViewResume();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("BaseActivity", "BaseActivity onStop");
        if (mPresenter!=null) {
            mPresenter.onViewStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("BaseActivity", "BaseActivity onDestroy");
        if (mPresenter!=null) {
            mPresenter.onViewDestroy();
        }
    }

    //获取Presenter
    protected T getPresenter() {
        return mPresenter;
    }
    //创建Presenter
    protected abstract T creatPresenter();

}
