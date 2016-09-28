package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.EducationEditModelImp;
import com.cjt.employment.model.Imodel.EducationEditModel;
import com.cjt.employment.model.Imodel.ProjectEditModel;
import com.cjt.employment.model.ProjectEditModelImp;
import com.cjt.employment.ui.activity.ProjectEditActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/28
 * 邮箱: 445263848@qq.com.
 */
public class ProjectEditPresenter extends BasePresenter<ProjectEditActivity> {
    private ProjectEditModel mProjectEditModel;

    public ProjectEditPresenter() {
        mProjectEditModel = ProjectEditModelImp.getInstance();
    }

    public void addProject(String action, String id, String projectname, String responsibility, String starttime, String endtime, String content) {
        if (mProjectEditModel != null) {
//            getView().showProgressBar();
            mProjectEditModel.addProject(action, id, projectname, responsibility, starttime, endtime, content)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
                            if (updateResult.getResult().equals("success")) {
                                Log.i("CJT", "success");
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
