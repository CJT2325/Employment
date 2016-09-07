package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.bean.UpLoadImageResult;
import com.cjt.employment.model.Imodel.LoginModel;
import com.cjt.employment.model.LoginModellImp;
import com.cjt.employment.ui.activity.LoginActivity;

import java.io.File;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/28
 * 邮箱: 445263848@qq.com.
 */
public class LoginPresenter extends BasePresenter<LoginActivity> {
    private LoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = LoginModellImp.getInstance();
    }

    public void login(String action, String phone, String password) {
        if (mLoginModel != null) {
            getView().showProgressBar();
            mLoginModel.login(action, phone, password)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<LoginResult>() {
                        @Override
                        public void call(LoginResult loginResult) {
                            if (loginResult.getResult().equals("success")) {
                                getView().loginSuccess(loginResult);
                            } else if (loginResult.getResult().equals("fail")) {
                                getView().loginFail();
                            }
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.i("RxJava", "又是在这里出现了问题呀----->" + throwable.toString());
                        }
                    });
        } else {
            Log.i("CJT", "model is null");
        }
    }
}
