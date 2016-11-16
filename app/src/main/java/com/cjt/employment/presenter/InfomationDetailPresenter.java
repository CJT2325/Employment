package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.InformationBean;
import com.cjt.employment.bean.InformationDetialBean;
import com.cjt.employment.model.ExploreModelImp;
import com.cjt.employment.model.Imodel.ExploreModel;
import com.cjt.employment.ui.activity.InfomationDetailActivity;
import com.cjt.employment.ui.fragment.ExploreView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/11/16
 * 邮箱: 445263848@qq.com.
 */
public class InfomationDetailPresenter extends BasePresenter<InfomationDetailActivity>{
    private ExploreModel mExploreModel;
    public InfomationDetailPresenter() {
        mExploreModel = ExploreModelImp.getInstance();
    }

    public void getInfomationDetial(String action,String id) {
        if (mExploreModel != null) {
            getView().showProgressBar();
            mExploreModel.getInfomationDetial(action,id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<InformationDetialBean>() {
                        @Override
                        public void call(InformationDetialBean informationDetialBean) {
                            getView().updateInfomationDetial(informationDetialBean.getData());
                            getView().hideProgressBar();
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.i("RxJava", "又是在这里出现了问题呀----->" + throwable.toString());
                            getView().hideProgressBar();
                        }
                    });
        } else {
            Log.i("CJT", "model is null");
        }
    }
}
