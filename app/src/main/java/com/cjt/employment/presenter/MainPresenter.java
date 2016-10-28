package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.AccountInfoBean;
import com.cjt.employment.bean.UserBean;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.model.Imodel.MainModel;
import com.cjt.employment.model.Imodel.VitageModel;
import com.cjt.employment.model.MainModelImp;
import com.cjt.employment.model.VitageModelImp;
import com.cjt.employment.ui.activity.MainActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/28
 * 邮箱: 445263848@qq.com.
 */
public class MainPresenter extends BasePresenter<MainActivity>{
    private MainModel mMainModel;

    public MainPresenter() {
        mMainModel = MainModelImp.getInstance();
    }

    public void getAccountInfo(String action, String id) {
        if (mMainModel != null) {
//            getView().showProgressBar();
            mMainModel.getAccountInfo(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UserBean>() {
                        @Override
                        public void call(UserBean userBean) {
                            getView().getAccountInfoSuccess(userBean);
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
