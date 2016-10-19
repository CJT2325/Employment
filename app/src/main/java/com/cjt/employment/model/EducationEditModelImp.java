package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.EducationEditModel;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;
import com.cjt.employment.ui.activity.EducationEditActivity;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public class EducationEditModelImp implements EducationEditModel {
    private ServerAPI mServerAPI;

    private EducationEditModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static EducationEditModel getInstance() {
        return EducationEditModelHolder.instance;
    }


    private final static class EducationEditModelHolder {
        private final static EducationEditModel instance = new EducationEditModelImp();
    }

    @Override
    public Observable<UpdateResult> addEducation(String action, String id, String schoolname, String major, String graduationtime, String education) {
        return mServerAPI.addEducation(action, id, schoolname, major, graduationtime, education);
    }
}
