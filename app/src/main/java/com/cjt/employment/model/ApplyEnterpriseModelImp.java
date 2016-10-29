package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.ApplyEnterpriseModel;
import com.cjt.employment.model.Imodel.CompanyInfoModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/29
 * 邮箱: 445263848@qq.com.
 */
public class ApplyEnterpriseModelImp implements ApplyEnterpriseModel {
    private ServerAPI mServerAPI;

    private ApplyEnterpriseModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static ApplyEnterpriseModel getInstance() {
        return ApplyEnterpriseModelHolder.instance;
    }

    private final static class ApplyEnterpriseModelHolder {
        private final static ApplyEnterpriseModel instance = new ApplyEnterpriseModelImp();
    }

    @Override
    public Observable<UpdateResult> applyEnterprise(String action, String id, String companyname) {
        return mServerAPI.applyEnterprise(action,id,companyname);
    }
}
