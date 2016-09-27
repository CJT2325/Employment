package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.Project;
import com.cjt.employment.model.EducationModelImp;
import com.cjt.employment.model.Imodel.EducationModel;
import com.cjt.employment.model.Imodel.ProjectModel;
import com.cjt.employment.model.ProjectModelImp;
import com.cjt.employment.ui.activity.ProjectActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/28
 * 邮箱: 445263848@qq.com.
 */
public class ProjectPresenter extends BasePresenter<ProjectActivity>{
    private ProjectModel mProjectModel;

    public ProjectPresenter() {
        mProjectModel = ProjectModelImp.getInstance();
    }

    public void getProjectList(String action, String id) {
        if (mProjectModel != null) {
//            getView().showProgressBar();
            mProjectModel.getProjectList(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Project>() {
                        @Override
                        public void call(Project project) {
                            Log.i("CJT",project.getData().size()+" ");
                            getView().getProjectSuccess(project.getData());
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
