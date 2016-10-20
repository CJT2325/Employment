package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageInfo;
import com.cjt.employment.model.EditCompanyPositionModelImp;
import com.cjt.employment.model.Imodel.EditCompanyPositionModel;
import com.cjt.employment.model.Imodel.VitageInfoModel;
import com.cjt.employment.model.VitageInfoModelImp;
import com.cjt.employment.ui.activity.VitageInfoActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/20
 * 邮箱: 445263848@qq.com.
 */
public class VitageInfoPresenter extends BasePresenter<VitageInfoActivity> {
    private VitageInfoModel mVitageInfoModel;

    public VitageInfoPresenter() {
        mVitageInfoModel = VitageInfoModelImp.getInstance();
    }

    public void getVitageInfoById(String action, String id) {
        if (mVitageInfoModel != null) {
            getView().showProgressBar();
            mVitageInfoModel.getVitageInfoById(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<VitageInfo>() {
                        @Override
                        public void call(VitageInfo citageInfo) {
                            getView().getVitageInfoSuccess(citageInfo.getData());
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
    public void seeVitageByAccountId(String action, String id) {
        if (mVitageInfoModel != null) {
            getView().showProgressBar();
            mVitageInfoModel.getVitageInfoById(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<VitageInfo>() {
                        @Override
                        public void call(VitageInfo citageInfo) {
                            getView().getVitageInfoSuccess(citageInfo.getData());
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
