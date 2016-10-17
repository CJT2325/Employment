package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.EnterpriseInfoModelImp;
import com.cjt.employment.model.Imodel.EnterpriseInfoModel;
import com.cjt.employment.ui.activity.EditControduceActivity;
import com.cjt.employment.ui.view.EnterpriseInfoView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/17
 * 邮箱: 445263848@qq.com.
 */
public class EditControducePresenter extends BasePresenter<EditControduceActivity> {
    private EnterpriseInfoModel mEnterpriseInfoModel;

    public EditControducePresenter() {
        mEnterpriseInfoModel = EnterpriseInfoModelImp.getInstance();
    }

    public void getCompanyControduceById(String action, String id) {
        if (mEnterpriseInfoModel != null) {
            getView().showProgressBar();
            mEnterpriseInfoModel.getCompanyControduceById(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<CompanyDescpt>() {
                        @Override
                        public void call(CompanyDescpt companyDescpt) {
                            getView().getControduceSuccess(companyDescpt.getData());
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

    public void updateCompanyControduceById(String action, String id, String content) {
        if (mEnterpriseInfoModel != null) {
            getView().showProgressBar();
            mEnterpriseInfoModel.updateCompanyControduceById(action, id, content)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")) {
                                getView().updateSuccess();
                                getView().hideProgressBar();
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
