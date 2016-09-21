package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.VitageUserEditModel;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public class WorkExperienceEditModelImp implements WorkExperienceEditModel {
    private ServerAPI mServerAPI;

    private WorkExperienceEditModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static WorkExperienceEditModel getInstance() {
        return WorkExperienceEditModelHolder.instance;
    }


    private final static class WorkExperienceEditModelHolder {
        private final static WorkExperienceEditModel instance = new WorkExperienceEditModelImp();
    }

    @Override
    public Observable<UpdateResult> addWorkExperience(String action, String id, String companyname, String position, String starttime, String endtime, String content) {
        return mServerAPI.addWorkExperience(action,id,companyname,position,starttime,endtime,content);
    }
}
