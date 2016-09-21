package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.HopeJobModelImp;
import com.cjt.employment.model.Imodel.HopeJobModel;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.WorkExperienceEditModelImp;
import com.cjt.employment.ui.activity.HopeJobEditActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/22
 * 邮箱: 445263848@qq.com.
 */
public class HopeJobPresenter extends BasePresenter<HopeJobEditActivity>{
    private HopeJobModel mHopeJobModel;

    public HopeJobPresenter() {
        mHopeJobModel = HopeJobModelImp.getInstance();
    }

    public void updateHopeJob(String action, String id, String hopeposition, String jobtype, String city, String money, String content) {
        if (mHopeJobModel != null) {
//            getView().showProgressBar();
            mHopeJobModel.updateHopeJob(action, id, hopeposition, jobtype, city, money, content)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")) {
                                Log.i("CJT","success");
                                getView().updateSuccess();
                            } else {
                                getView().updateFail();
                            }
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
