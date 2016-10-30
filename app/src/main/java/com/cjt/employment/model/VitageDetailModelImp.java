package com.cjt.employment.model;

import com.cjt.employment.bean.VitageDetailBean;
import com.cjt.employment.model.Imodel.EditCompanyPositionModel;
import com.cjt.employment.model.Imodel.VitageDetailModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/30
 * 邮箱: 445263848@qq.com.
 */
public class VitageDetailModelImp implements VitageDetailModel {
    private ServerAPI mServerAPI;

    private VitageDetailModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static VitageDetailModel getInstance() {
        return VitageDetailModelHolder.instance;
    }


    private final static class VitageDetailModelHolder {
        private final static VitageDetailModel instance = new VitageDetailModelImp();
    }

    @Override
    public Observable<VitageDetailBean> getVitageDetail(String action, String id) {
        return mServerAPI.getVitageDetail(action,id);
    }
}
