package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.ApplyEnterpriseModelImp;
import com.cjt.employment.model.EditCompanyPositionModelImp;
import com.cjt.employment.model.Imodel.ApplyEnterpriseModel;
import com.cjt.employment.model.Imodel.EditCompanyPositionModel;
import com.cjt.employment.ui.activity.ApplyEnterpriseActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/29
 * 邮箱: 445263848@qq.com.
 */
public class ApplyEnterprisePresenter extends BasePresenter<ApplyEnterpriseActivity> {
    private ApplyEnterpriseModel mApplyEnterpriseModel;

    public ApplyEnterprisePresenter() {
        mApplyEnterpriseModel = ApplyEnterpriseModelImp.getInstance();
    }

    public void applyEnterprise(String action, String id, String companyname) {
        if (mApplyEnterpriseModel != null) {
            getView().showProgressBar();
            mApplyEnterpriseModel.applyEnterprise(action, id, companyname)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")) {
                                getView().applySuccess();
                            } else if (updateResult.getResult().equals("fail")) {
                                getView().applyFail();
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
