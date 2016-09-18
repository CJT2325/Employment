package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.model.Imodel.LoginModel;
import com.cjt.employment.model.Imodel.VitageModel;
import com.cjt.employment.model.LoginModellImp;
import com.cjt.employment.model.VitageModelImp;
import com.cjt.employment.ui.activity.VitaeActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/9
 * 邮箱: 445263848@qq.com.
 */
public class VitagePresenter extends BasePresenter<VitaeActivity>{
    private VitageModel mVitageModel;

    public VitagePresenter() {
        mVitageModel = VitageModelImp.getInstance();
    }

    public void getVitageUser(String action, String id) {
        if (mVitageModel != null) {
//            getView().showProgressBar();
            mVitageModel.getVitageUser(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<VitageBean>() {
                        @Override
                        public void call(VitageBean vitageBean) {
                            if (vitageBean.getResult().equals("success")){
                                getView().getVitageSuccess(vitageBean.getData());
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