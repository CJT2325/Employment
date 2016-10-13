package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.model.AllVitageModelImp;
import com.cjt.employment.model.Imodel.AllVitageModel;
import com.cjt.employment.ui.fragment.InterviewVitageFragment;
import com.cjt.employment.ui.view.AllVitageView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/14
 * 邮箱: 445263848@qq.com.
 */
public class InterviewVitagePresenter extends BasePresenter<InterviewVitageFragment>{
    private AllVitageModel mAllVitageModel;
    private AllVitageView mAllVitageView;

    public InterviewVitagePresenter(AllVitageView allVitageView) {
        mAllVitageModel = AllVitageModelImp.getInstance();
        this.mAllVitageView = allVitageView;
    }

    public void getRecruit(String action, String id,String state) {
        if (mAllVitageModel != null) {
            mAllVitageView.showProgressBar();
            mAllVitageModel.getUserVitage(action, id,state)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UserVitage>() {
                        @Override
                        public void call(UserVitage userVitage) {
                            mAllVitageView.getAllVitageSuccess(userVitage.getData());
                            mAllVitageView.hideProgressBar();
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
