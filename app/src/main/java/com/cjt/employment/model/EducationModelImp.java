package com.cjt.employment.model;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.model.Imodel.EducationModel;
import com.cjt.employment.model.Imodel.WorkExperienceModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public class EducationModelImp implements EducationModel{

    private ServerAPI mServerAPI;

    private EducationModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static EducationModel getInstance() {
        return EducationModelHolder.instance;
    }


    private final static class EducationModelHolder {
        private final static EducationModel instance = new EducationModelImp();
    }
    @Override
    public Observable<Education> getEducationList(String action, String id) {
        return mServerAPI.getEducationList(action,id);
    }
}
