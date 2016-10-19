package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.CompanyPosition;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.CompanyInfoModelImp;
import com.cjt.employment.model.EditCompanyPositionModelImp;
import com.cjt.employment.model.Imodel.CompanyInfoModel;
import com.cjt.employment.model.Imodel.EditCompanyPositionModel;
import com.cjt.employment.ui.activity.EditCompanyPositionActivity;
import com.cjt.employment.ui.view.CompanyInfoView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/19
 * 邮箱: 445263848@qq.com.
 */
public class EditCompanyPositionPresenter extends BasePresenter<EditCompanyPositionActivity> {
    private EditCompanyPositionModel mEditCompanyPositionModel;

    public EditCompanyPositionPresenter() {
        mEditCompanyPositionModel = EditCompanyPositionModelImp.getInstance();
    }

    public void addCompanyPosition(String action, String id, String position, String type, String education, String number, String startwarge, String endwarge, String startworktime, String endworktime, String city, String address, String content) {
        if (mEditCompanyPositionModel != null) {
            getView().showProgressBar();
            mEditCompanyPositionModel.addCompanyPosition(action, id, position, type, education, number, startwarge, endwarge, startworktime, endworktime, city, address, content)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")) {
                                getView().addCompanyPositionSuccess();
                            } else if (updateResult.getResult().equals("fail")) {
                                getView().addCompanyPositionFail();
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

    public void getCompanyPositionById(String action, String id) {
        if (mEditCompanyPositionModel != null) {
            getView().showProgressBar();
            mEditCompanyPositionModel.getCompanyPositionById(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<CompanyPosition>() {
                        @Override
                        public void call(CompanyPosition companyPosition) {
                            getView().getCompanyPositionSuccess(companyPosition.getData());
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
