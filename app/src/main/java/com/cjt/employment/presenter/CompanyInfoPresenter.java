package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.CompanyInfoModelImp;
import com.cjt.employment.model.Imodel.CompanyInfoModel;
import com.cjt.employment.ui.fragment.CompanyInfoFragment;
import com.cjt.employment.ui.view.CompanyInfoView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/12
 * 邮箱: 445263848@qq.com.
 */
public class CompanyInfoPresenter extends BasePresenter<CompanyInfoFragment> {
    private CompanyInfoModel mCompanyInfoModel;
    private CompanyInfoView mCompanyInfoView;

    public CompanyInfoPresenter(CompanyInfoView mCompanyInfoView) {
        mCompanyInfoModel = CompanyInfoModelImp.getInstance();
        this.mCompanyInfoView = mCompanyInfoView;
    }

    public void getCompanyInfoByCompanyId(String action, int id) {
        if (mCompanyInfoModel != null) {
            mCompanyInfoModel.getCompanyInfoByCompanyId(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<CompanyInfo>() {
                        @Override
                        public void call(CompanyInfo companyInfo) {
//                            Log.i("CJT", companyInfo.getData().size() + " ");
                            mCompanyInfoView.updateCompanyInfo(companyInfo.getData());
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
