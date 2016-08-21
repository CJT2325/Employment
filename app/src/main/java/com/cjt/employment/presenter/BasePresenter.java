package com.cjt.employment.presenter;

import android.util.Log;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 作者: 陈嘉桐 on 2016/7/1
 * 邮箱: 445263848@qq.com.
 */
public abstract class BasePresenter<T> {

    protected Reference<T> mViewRef;
    //绑定View
    public <V> void attachView(T view){
        mViewRef=new WeakReference<T>(view);
    }
    //获取绑定的View
    protected T getView(){
        if (mViewRef.get()!=null){
            return mViewRef.get();
        }else{
            return null;
        }
    }
    //判断Presenter是否与View绑定
    public boolean isAttachedView() {
        return mViewRef.get() == null ? false : true;
    }
    //解除绑定
    public void datachView(){
        if (mViewRef.get()!=null){
            mViewRef.clear();
            mViewRef=null;
        }
    }

    public void onViewCreate() {
        Log.i("BasePresenter", "BasePresenter onViewCreate");
    }

    public void onViewResume() {
        Log.i("BasePresenter", "BasePresenter onViewResume");
    }

    public void onViewStart() {
        Log.i("BasePresenter", "BasePresenter onViewStart");
    }

    public void onViewStop() {
        Log.i("BasePresenter", "BasePresenter onViewStop");
    }

    public void onViewDestroy() {
        Log.i("BasePresenter", "BasePresenter onViewDestroy");
    }
}
