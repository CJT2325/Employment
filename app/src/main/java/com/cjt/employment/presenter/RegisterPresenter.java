package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.RecruitmentInfoModel;
import com.cjt.employment.model.Imodel.RegisterModel;
import com.cjt.employment.model.RecruitmentInfoModelImp;
import com.cjt.employment.model.RegisterModelImp;
import com.cjt.employment.ui.activity.RegisterActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/23
 * 邮箱: 445263848@qq.com.
 */
public class RegisterPresenter extends BasePresenter<RegisterActivity> {
    private RegisterModel mRegisterModel;

    public RegisterPresenter() {
        mRegisterModel = RegisterModelImp.getInstance();
    }

    public void resgister(String action, String phone, String password) {
        if (mRegisterModel != null) {
            getView().showProgressBar();
            mRegisterModel.resgister(action, phone, password)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")){
                                getView().registerSuccess();
                            }else{
                                getView().registerFail();
                            }
                            getView().hideProgressBar();
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
