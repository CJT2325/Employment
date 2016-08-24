package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.CompanyInfoModelImp;
import com.cjt.employment.model.Imodel.CompanyInfoModel;
import com.cjt.employment.ui.fragment.PositionFragment;
import com.cjt.employment.ui.view.CompanyInfoView;
import com.cjt.employment.ui.view.PositionView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/8/18
 * 邮箱: 445263848@qq.com.
 */
public class PositionPresenter extends BasePresenter<PositionFragment>{
    private CompanyInfoModel mCompanyInfoModel;
    private PositionView mPositionView;

    public PositionPresenter(PositionView mPositionView) {
        mCompanyInfoModel = CompanyInfoModelImp.getInstance();
        this.mPositionView = mPositionView;
    }

    public void getRecruitInfoByCompanyId(String action, int id) {
        if (mCompanyInfoModel != null) {
            mCompanyInfoModel.getRecruitByCompanyId(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Recruit>() {
                        @Override
                        public void call(Recruit recruit) {
//                            Log.i("CJT", companyInfo.getData().size() + " ");
                            mPositionView.updatePositionInfo(recruit.getData());
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
