package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.RecruitModelImp;
import com.cjt.employment.ui.fragment.EnterpriseInfoFragment;
import com.cjt.employment.ui.fragment.EnterpriseVitageFragment;
import com.cjt.employment.ui.view.HomeView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/12
 * 邮箱: 445263848@qq.com.
 */
public class EnterpriseInfoPresenter extends BasePresenter<EnterpriseInfoFragment> {
    private RecruitModel mRecruitModel;
    private HomeView mHomeView;

    public EnterpriseInfoPresenter(HomeView homeView) {
        mRecruitModel = RecruitModelImp.getInstance();
        this.mHomeView = homeView;
    }

    public void getPositionByCompanyId(String action, String companyid) {
        if (mRecruitModel != null) {
            mRecruitModel.getRecruit(action)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Recruit>() {
                        @Override
                        public void call(Recruit recruit) {
                            Log.i("CJT", recruit.getData().size() + " ");
                            mHomeView.updateRecruit(recruit.getData());
//                            mHomeView.updata(shopList.getVendors());
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
