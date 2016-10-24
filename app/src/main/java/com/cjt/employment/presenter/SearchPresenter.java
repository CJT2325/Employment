package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.model.Imodel.SearchModel;
import com.cjt.employment.model.SearchModelImp;
import com.cjt.employment.ui.activity.SearchActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/10/10
 * 邮箱: 445263848@qq.com.
 */
public class SearchPresenter extends BasePresenter<SearchActivity> {
    private SearchModel mSearchPresenterModel;

    public SearchPresenter() {
        mSearchPresenterModel = SearchModelImp.getInstance();
    }

    public void searchRecruitment(String action, String query, String city, String type, String education) {
        if (mSearchPresenterModel != null) {
            getView().showProgressBar();
            mSearchPresenterModel.searchRecruitment(action, query, city, type, education)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Recruit>() {
                        @Override
                        public void call(Recruit recruit) {
                            getView().searchSuccess(recruit.getData());
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

}
