package com.cjt.employment.model;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.Project;
import com.cjt.employment.model.Imodel.EducationModel;
import com.cjt.employment.model.Imodel.ProjectModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/28
 * 邮箱: 445263848@qq.com.
 */
public class ProjectModelImp implements ProjectModel{
    private ServerAPI mServerAPI;

    private ProjectModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static ProjectModel getInstance() {
        return ProjectModelHolder.instance;
    }


    private final static class ProjectModelHolder {
        private final static ProjectModel instance = new ProjectModelImp();
    }

    @Override
    public Observable<Project> getProjectList(String action, String id) {
        return mServerAPI.getProjectList(action,id);
    }
}
