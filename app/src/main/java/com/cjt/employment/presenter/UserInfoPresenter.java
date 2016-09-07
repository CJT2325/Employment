package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.model.Imodel.LoginModel;
import com.cjt.employment.model.Imodel.UserInfoModel;
import com.cjt.employment.model.LoginModellImp;
import com.cjt.employment.model.UserInfoModelImp;
import com.cjt.employment.ui.activity.UserInfoActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/7
 * 邮箱: 445263848@qq.com.
 */
public class UserInfoPresenter extends BasePresenter<UserInfoActivity> {
    private UserInfoModel mUserInfoModel;

    public UserInfoPresenter() {
        mUserInfoModel = UserInfoModelImp.getInstance();
    }

    public void getUserCover(String action, String id) {
        if (mUserInfoModel != null) {
            mUserInfoModel.getUserCover(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<AccountInfo>() {
                        @Override
                        public void call(AccountInfo accountInfo) {
                            getView().getUserCoverSuccess(accountInfo);
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
