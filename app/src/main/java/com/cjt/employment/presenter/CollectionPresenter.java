package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.CollectionBean;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.CollectionModelImp;
import com.cjt.employment.model.Imodel.CollectionModel;
import com.cjt.employment.ui.activity.CollectionActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/30
 * 邮箱: 445263848@qq.com.
 */
public class CollectionPresenter extends BasePresenter<CollectionActivity> {
    private CollectionModel mCollectionModel;

    public CollectionPresenter() {
        mCollectionModel = CollectionModelImp.getInstance();
    }

    public void getCollection(String action, String id) {
        if (mCollectionModel != null) {
            getView().showProgressBar();
            mCollectionModel.getCollection(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<CollectionBean>() {
                        @Override
                        public void call(CollectionBean collectionBean) {
                            getView().getCollectionSuccess(collectionBean.getData());
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

    public void deleteCollectionById(String action, String id, String recruitid) {
        if (mCollectionModel != null) {
            getView().showProgressBar();
            mCollectionModel.deleteCollectionById(action, id, recruitid)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")) {
                                getView().deleteSuccess();
                            } else {
                                getView().deleteFail();
                            }
//                            getView().getCollectionSuccess(collectionBean.getData());
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

    public void sendVitage(String action, String id, int recruitid, int companyid) {
        if (mCollectionModel != null) {
            getView().showProgressBar();
            mCollectionModel.sendVitage(action, id, recruitid, companyid)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")){
                                getView().sendVitageSuccess();
                            }else {
                                getView().sendVitageFail();
                            }
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
