package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.VitageDetailBean;
import com.cjt.employment.model.Imodel.VitageDetailModel;
import com.cjt.employment.model.Imodel.VitageModel;
import com.cjt.employment.model.VitageDetailModelImp;
import com.cjt.employment.model.VitageModelImp;
import com.cjt.employment.ui.activity.VitageDetailActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/30
 * 邮箱: 445263848@qq.com.
 */
public class VitageDetailPresenter extends BasePresenter<VitageDetailActivity>{
    private VitageDetailModel mVitageDetailModel;

    public VitageDetailPresenter() {
        mVitageDetailModel = VitageDetailModelImp.getInstance();
    }

    public void getVitageDetail(String action, String id) {
        if (mVitageDetailModel != null) {
            getView().showProgressBar();
            mVitageDetailModel.getVitageDetail(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<VitageDetailBean>() {
                        @Override
                        public void call(VitageDetailBean vitageDetailBean) {
                            getView().getVitageDetailSuccess(vitageDetailBean.getData());
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
