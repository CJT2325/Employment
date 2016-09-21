package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.EducationEditModelImp;
import com.cjt.employment.model.Imodel.EducationEditModel;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.WorkExperienceEditModelImp;
import com.cjt.employment.ui.activity.EducationActivity;
import com.cjt.employment.ui.activity.EducationEditActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public class EducationEditPresenter extends BasePresenter<EducationEditActivity>{
    private EducationEditModel mEducationEditModel;

    public EducationEditPresenter() {
        mEducationEditModel = EducationEditModelImp.getInstance();
    }

    public void addEducation(String action, String id, String schoolname, String major, String graduationtime, String education) {
        if (mEducationEditModel != null) {
//            getView().showProgressBar();
            mEducationEditModel.addEducation(action, id, schoolname, major, graduationtime, education)
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
