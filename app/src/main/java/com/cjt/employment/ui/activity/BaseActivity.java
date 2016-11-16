package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.cjt.employment.bean.InformationDetialBean;
import com.cjt.employment.presenter.BasePresenter;


/**
 * 作者: 陈嘉桐 on 2016/7/1
 * 邮箱: 445263848@qq.com.
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity{
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BaseActivity", "BaseActivity onCreate");
        mPresenter = creatPresenter();
        mPresenter.attachView((V) this);
        mPresenter.onViewCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("BaseActivity", "BaseActivity onStart");
        mPresenter.onViewStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BaseActivity", "BaseActivity onResume");
        mPresenter.onViewResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BaseActivity", "BaseActivity onStop");
        mPresenter.onViewStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("BaseActivity", "BaseActivity onDestroy");
        mPresenter.onViewDestroy();
    }

    protected T getPresenter() {
        return mPresenter;
    }


    protected abstract T creatPresenter();


}
