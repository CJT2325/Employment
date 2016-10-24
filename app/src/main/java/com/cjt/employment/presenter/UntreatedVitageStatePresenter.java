package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.VitageStateBean;
import com.cjt.employment.model.AllVitageStateModelImp;
import com.cjt.employment.model.Imodel.AllVitageStateModel;
import com.cjt.employment.ui.fragment.AllVitageStateFragment;
import com.cjt.employment.ui.fragment.UntreatedVitageStateFragment;
import com.cjt.employment.ui.view.AllVitageStateView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public class UntreatedVitageStatePresenter extends BasePresenter<UntreatedVitageStateFragment> {
    private AllVitageStateModel mAllVitageStateModel;
    private AllVitageStateView mAllVitageStateView;

    public UntreatedVitageStatePresenter(AllVitageStateView allVitageStateView) {
        mAllVitageStateModel = AllVitageStateModelImp.getInstance();
        this.mAllVitageStateView = allVitageStateView;
    }

    public void getAllStateVitage(String action, String id,String state) {
        if (mAllVitageStateModel != null) {
            mAllVitageStateView.showProgressBar();
            mAllVitageStateModel.getAllStateVitage(action, id,state)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<VitageStateBean>() {
                        @Override
                        public void call(VitageStateBean vitageStateBean) {
                            mAllVitageStateView.getAllVitageStateSuccess(vitageStateBean.getData());
                            mAllVitageStateView.hideProgressBar();
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
