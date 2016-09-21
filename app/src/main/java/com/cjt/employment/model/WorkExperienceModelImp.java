package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.Imodel.WorkExperienceModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public class WorkExperienceModelImp implements WorkExperienceModel{
    private ServerAPI mServerAPI;

    private WorkExperienceModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static WorkExperienceModel getInstance() {
        return WorkExperienceModelHolder.instance;
    }


    private final static class WorkExperienceModelHolder {
        private final static WorkExperienceModel instance = new WorkExperienceModelImp();
    }
    @Override
    public Observable<WorkExperience> getWorkExperienceList(String action, String id) {
        return mServerAPI.getWorkExperienceList(action, id);
    }
}
