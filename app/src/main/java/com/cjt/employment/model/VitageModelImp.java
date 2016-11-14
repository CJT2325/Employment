package com.cjt.employment.model;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.HopeJob;
import com.cjt.employment.bean.Project;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.model.Imodel.VitageModel;
import com.cjt.employment.model.Imodel.VitageUserEditModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/17
 * 邮箱: 445263848@qq.com.
 */
public class VitageModelImp implements VitageModel{
    private ServerAPI mServerAPI;

    private VitageModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static VitageModel getInstance() {
        return VitageModelHolder.instance;
    }


    private final static class VitageModelHolder {
        private final static VitageModel instance = new VitageModelImp();
    }

    @Override
    public Observable<AccountInfo> getAccountInfoById(String action, int id) {
        return mServerAPI.getAccountInfoById(action,id);
    }

    @Override
    public Observable<VitageBean> getVitageUser(String action, String id) {
        return mServerAPI.getVitageUser(action,id);
    }

    @Override
    public Observable<HopeJob> getHopeJob(String action, String id) {
        return mServerAPI.getHopeJob(action,id);
    }

    @Override
    public Observable<WorkExperience> getWorkExperienceList(String action, String id) {
        return mServerAPI.getWorkExperienceList(action,id);
    }

    @Override
    public Observable<Education> getEducationList(String action, String id) {
        return mServerAPI.getEducationList(action,id);
    }

    @Override
    public Observable<Project> getProjectList(String action, String id) {
        return mServerAPI.getProjectList(action,id);
    }
}
