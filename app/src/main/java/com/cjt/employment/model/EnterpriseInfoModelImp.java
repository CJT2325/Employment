package com.cjt.employment.model;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.model.Imodel.EnterpriseInfoModel;
import com.cjt.employment.model.Imodel.EnterprisePositionModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/16
 * 邮箱: 445263848@qq.com.
 */
public class EnterpriseInfoModelImp implements EnterpriseInfoModel{
    private ServerAPI mServerAPI;

    private EnterpriseInfoModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static EnterpriseInfoModel getInstance() {
        return EnterpriseInfoModelHolder.instance;
    }


    private final static class EnterpriseInfoModelHolder {
        private final static EnterpriseInfoModel instance = new EnterpriseInfoModelImp();
    }

    @Override
    public Observable<CompanyInfo> getEnterpriseInfo(String action, String id) {
        return mServerAPI.getEnterpriseInfo(action,id);
    }
}
