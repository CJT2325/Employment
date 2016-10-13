package com.cjt.employment.model;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.model.Imodel.AllVitageModel;
import com.cjt.employment.model.Imodel.EducationModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public class AllVitageModelImp implements AllVitageModel {
    private ServerAPI mServerAPI;

    private AllVitageModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static AllVitageModel getInstance() {
        return AllVitageModelHolder.instance;
    }

    private final static class AllVitageModelHolder {
        private final static AllVitageModel instance = new AllVitageModelImp();
    }

    @Override
    public Observable<UserVitage> getUserVitage(String action, String id,String state) {
        return mServerAPI.getUserVitage(action,id,state);
    }
}
