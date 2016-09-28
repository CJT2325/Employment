package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.EducationEditModel;
import com.cjt.employment.model.Imodel.ProjectEditModel;
import com.cjt.employment.model.Imodel.ProjectModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/28
 * 邮箱: 445263848@qq.com.
 */
public class ProjectEditModelImp implements ProjectEditModel{
    private ServerAPI mServerAPI;

    private ProjectEditModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static ProjectEditModel getInstance() {
        return ProjectEditModelHolder.instance;
    }


    private final static class ProjectEditModelHolder {
        private final static ProjectEditModel instance = new ProjectEditModelImp();
    }

    @Override
    public Observable<UpdateResult> addProject(String action, String id, String projectname, String responsibility, String starttime, String endtime, String content) {
        return mServerAPI.addProject(action,id,projectname,responsibility,starttime,endtime,content);
    }
}
