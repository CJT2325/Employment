package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.EnterpriseInfoModelImp;
import com.cjt.employment.model.Imodel.EnterpriseInfoModel;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.RecruitModelImp;
import com.cjt.employment.ui.fragment.EnterpriseInfoFragment;
import com.cjt.employment.ui.fragment.EnterpriseVitageFragment;
import com.cjt.employment.ui.view.EnterpriseInfoView;
import com.cjt.employment.ui.view.HomeView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/12
 * 邮箱: 445263848@qq.com.
 */
public class EnterpriseInfoPresenter extends BasePresenter<EnterpriseInfoFragment> {
    private EnterpriseInfoModel mEnterpriseInfoModel;
    private EnterpriseInfoView mEnterpriseInfoView;

    public EnterpriseInfoPresenter(EnterpriseInfoView enterpriseInfoView) {
        mEnterpriseInfoModel = EnterpriseInfoModelImp.getInstance();
        this.mEnterpriseInfoView = enterpriseInfoView;
    }

    public void getPositionByCompanyId(String action, String id) {
        if (mEnterpriseInfoModel != null) {
            mEnterpriseInfoView.showProgressBar();
            mEnterpriseInfoModel.getEnterpriseInfo(action,id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<CompanyInfo>() {
                        @Override
                        public void call(CompanyInfo companyInfo) {
                            mEnterpriseInfoView.getCompanyInfoSuccess(companyInfo.getData());
                            mEnterpriseInfoView.hideProgressBar();
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
