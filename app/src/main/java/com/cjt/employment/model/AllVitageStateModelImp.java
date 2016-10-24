package com.cjt.employment.model;

import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.bean.VitageStateBean;
import com.cjt.employment.model.Imodel.AllVitageModel;
import com.cjt.employment.model.Imodel.AllVitageStateModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public class AllVitageStateModelImp implements AllVitageStateModel {
    private ServerAPI mServerAPI;

    private AllVitageStateModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static AllVitageStateModel getInstance() {
        return AllVitageStateModelHolder.instance;
    }

    private final static class AllVitageStateModelHolder {
        private final static AllVitageStateModel instance = new AllVitageStateModelImp();
    }

    @Override
    public Observable<VitageStateBean> getAllStateVitage(String action, String id, String state) {
        return mServerAPI.getAllStateVitage(action,id,state);
    }

}
