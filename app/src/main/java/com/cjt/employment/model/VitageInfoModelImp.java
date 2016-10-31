package com.cjt.employment.model;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageInfo;
import com.cjt.employment.model.Imodel.EnterpriseInfoModel;
import com.cjt.employment.model.Imodel.VitageInfoModel;
import com.cjt.employment.model.Imodel.VitageModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/20
 * 邮箱: 445263848@qq.com.
 */
public class VitageInfoModelImp implements VitageInfoModel {
    private ServerAPI mServerAPI;

    private VitageInfoModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static VitageInfoModel getInstance() {
        return VitageInfoModelHolder.instance;
    }

    private final static class VitageInfoModelHolder {
        private final static VitageInfoModel instance = new VitageInfoModelImp();
    }

    @Override
    public Observable<VitageInfo> getVitageInfoById(String action, String id) {
        return mServerAPI.getVitageInfoById(action, id);
    }

    @Override
    public Observable<UpdateResult> updateVitageState(String action, String id, String state, String result) {
        return mServerAPI.updateVitageState(action, id, state,result);
    }

}
