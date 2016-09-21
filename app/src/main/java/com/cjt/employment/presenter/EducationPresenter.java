package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.model.EducationModelImp;
import com.cjt.employment.model.Imodel.EducationModel;
import com.cjt.employment.model.Imodel.WorkExperienceModel;
import com.cjt.employment.model.WorkExperienceModelImp;
import com.cjt.employment.ui.activity.EducationActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public class EducationPresenter extends BasePresenter<EducationActivity>{
    private EducationModel mEducationModel;

    public EducationPresenter() {
        mEducationModel = EducationModelImp.getInstance();
    }

    public void getEducationList(String action, String id) {
        if (mEducationModel != null) {
            getView().showProgressBar();
            mEducationModel.getEducationList(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Education>() {
                        @Override
                        public void call(Education education) {
                            getView().getEducationSuccess(education.getData());
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
