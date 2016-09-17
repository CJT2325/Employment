package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageBean;
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
    public Observable<VitageBean> getVitageUser(String action, String id) {
        return mServerAPI.getVitageUser(action,id);
    }
}
