package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.Imodel.WorkExperienceModel;
import com.cjt.employment.model.WorkExperienceEditModelImp;
import com.cjt.employment.model.WorkExperienceModelImp;
import com.cjt.employment.ui.activity.WorkExperienceActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public class WorkExperiencePresenter extends BasePresenter<WorkExperienceActivity>{
    private WorkExperienceModel mWorkExperienceModel;

    public WorkExperiencePresenter() {
        mWorkExperienceModel = WorkExperienceModelImp.getInstance();
    }

    public void getWorkExperienceList(String action, String id) {
        if (mWorkExperienceModel != null) {
//            getView().showProgressBar();
            mWorkExperienceModel.getWorkExperienceList(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<WorkExperience>() {
                        @Override
                        public void call(WorkExperience workExperience) {
                                getView().getWorkExperienceSuccess(workExperience.getData());
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
