package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.CompanyProject;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.EnterpriseInfoModelImp;
import com.cjt.employment.model.Imodel.EnterpriseInfoModel;
import com.cjt.employment.ui.activity.EditProjectControduceActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/11/15
 * 邮箱: 445263848@qq.com.
 */
public class EditProjectControducePresenter extends BasePresenter<EditProjectControduceActivity>{
    private EnterpriseInfoModel mEnterpriseInfoModel;

    public EditProjectControducePresenter() {
        mEnterpriseInfoModel = EnterpriseInfoModelImp.getInstance();
    }

    public void getProjectControduceById(String action, String id) {
        if (mEnterpriseInfoModel != null) {
            getView().showProgressBar();
            mEnterpriseInfoModel.getProjectControduceById(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<CompanyProject>() {
                        @Override
                        public void call(CompanyProject companyProject) {
                            getView().getProjectControduceSuccess(companyProject.getData());
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

    public void updateProjectControduceById(String action, String id, String content) {
        if (mEnterpriseInfoModel != null) {
            getView().showProgressBar();
            mEnterpriseInfoModel.updateProjectControduceById(action, id, content)
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
