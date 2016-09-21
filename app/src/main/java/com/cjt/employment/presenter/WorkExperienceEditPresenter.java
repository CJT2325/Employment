package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.VitageUserEditModel;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.VitageUserEditModelImp;
import com.cjt.employment.model.WorkExperienceEditModelImp;
import com.cjt.employment.ui.activity.WorkExperienceEditActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public class WorkExperienceEditPresenter extends BasePresenter<WorkExperienceEditActivity> {
    private WorkExperienceEditModel mWorkExperienceEditModel;

    public WorkExperienceEditPresenter() {
        mWorkExperienceEditModel = WorkExperienceEditModelImp.getInstance();
    }

    public void addWorkExperience(String action, String id, String companyname, String position, String starttime, String endtime, String content) {
        if (mWorkExperienceEditModel != null) {
//            getView().showProgressBar();
            mWorkExperienceEditModel.addWorkExperience(action, id, companyname, position, starttime, endtime, content)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")) {
                                Log.i("CJT","success");
//                                getView().updateSuccess();
                            } else {
//                                getView().updateFail();
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
