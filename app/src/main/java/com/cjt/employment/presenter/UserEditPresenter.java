package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.bean.UpLoadImageResult;
import com.cjt.employment.model.Imodel.RecruitmentInfoModel;
import com.cjt.employment.model.Imodel.UserEditModel;
import com.cjt.employment.model.RecruitmentInfoModelImp;
import com.cjt.employment.model.UserEditModelImp;
import com.cjt.employment.ui.activity.UserEditActivity;

import java.io.File;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/26
 * 邮箱: 445263848@qq.com.
 */
public class UserEditPresenter extends BasePresenter<UserEditActivity> {
    private UserEditModel mUserEditModel;

    public UserEditPresenter() {
        mUserEditModel = UserEditModelImp.getInstance();
    }

    public void upLoadImage(String action, int id, File file) {
        if (mUserEditModel != null) {
            getView().showProgressBar();
            mUserEditModel.uploadImage(action, id, file)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpLoadImageResult>() {
                        @Override
                        public void call(UpLoadImageResult upLoadImageResult) {
                            Log.i("CJT", upLoadImageResult.getResult());
                            getView().upLoadImageSuccess();
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

    public void getAccountInfoById(String getAccountInfo, int id) {
        if (mUserEditModel != null) {
            getView().showProgressBar();
            mUserEditModel.getAccountInfoById(getAccountInfo, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<AccountInfo>() {
                        @Override
                        public void call(AccountInfo accountInfo) {
                            getView().updateAccountInfo(accountInfo.getData());
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

    public void updateName(String action, int id, String name) {
        if (mUserEditModel != null) {
            getView().showProgressBar();
            mUserEditModel.updateName(action,id, name)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpLoadImageResult>() {
                        @Override
                        public void call(UpLoadImageResult upLoadImageResult) {
                            getView().updateNameSuccess();
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
