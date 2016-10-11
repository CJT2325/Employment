package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.EnterprisePositionModelImp;
import com.cjt.employment.model.Imodel.EnterprisePositionModel;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.RecruitModelImp;
import com.cjt.employment.ui.fragment.EnterprisePositionFragment;
import com.cjt.employment.ui.fragment.HomeFragment;
import com.cjt.employment.ui.view.EnterprisePositionView;
import com.cjt.employment.ui.view.HomeView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/12
 * 邮箱: 445263848@qq.com.
 */
public class EnterprisePositionPresenter extends BasePresenter<EnterprisePositionFragment> {
    private EnterprisePositionModel mEnterprisePositionModel;
    private EnterprisePositionView mEnterprisePositionView;

    public EnterprisePositionPresenter(EnterprisePositionView enterprisePositionView) {
        mEnterprisePositionModel = EnterprisePositionModelImp.getInstance();
        this.mEnterprisePositionView = enterprisePositionView;
    }

    public void getPositionByCompanyId(String action, String id) {
        if (mEnterprisePositionModel != null) {
            mEnterprisePositionView.showProgressBar();
            mEnterprisePositionModel.getPositionByCompanyId(action,id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<EnterprisePosition>() {
                        @Override
                        public void call(EnterprisePosition enterprisePosition) {
                            mEnterprisePositionView.getEnterprisePositionSuccess(enterprisePosition.getData());
                            mEnterprisePositionView.hideProgressBar();
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
