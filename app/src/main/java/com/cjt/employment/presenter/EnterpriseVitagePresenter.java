package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.RecruitModelImp;
import com.cjt.employment.ui.fragment.EnterprisePositionFragment;
import com.cjt.employment.ui.fragment.EnterpriseVitageFragment;
import com.cjt.employment.ui.view.EnterpriseVitageView;
import com.cjt.employment.ui.view.HomeView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/12
 * 邮箱: 445263848@qq.com.
 */
public class EnterpriseVitagePresenter extends BasePresenter<EnterpriseVitageFragment> {
    private RecruitModel mRecruitModel;
    private EnterpriseVitageView enterpriseVitageView;

    public EnterpriseVitagePresenter(EnterpriseVitageView enterpriseVitageView) {
        mRecruitModel = RecruitModelImp.getInstance();
        this.enterpriseVitageView = enterpriseVitageView;
    }

    public void getPositionByCompanyId(String action, String companyid) {
        if (mRecruitModel != null) {
            mRecruitModel.getRecruit(action)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Recruit>() {
                        @Override
                        public void call(Recruit recruit) {
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
