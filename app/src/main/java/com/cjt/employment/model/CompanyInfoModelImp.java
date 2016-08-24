package com.cjt.employment.model;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.Imodel.CompanyInfoModel;
import com.cjt.employment.model.Imodel.RecruitmentInfoModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/24
 * 邮箱: 445263848@qq.com.
 */
public class CompanyInfoModelImp implements CompanyInfoModel {
    private ServerAPI mServerAPI;

    private CompanyInfoModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static CompanyInfoModel getInstance() {
        return CompanyInfoModelHolder.instance;
    }

    private final static class CompanyInfoModelHolder {
        private final static CompanyInfoModelImp instance = new CompanyInfoModelImp();
    }

    @Override
    public Observable<CompanyInfo> getCompanyInfoByCompanyId(String action, int id) {
        return mServerAPI.getCompanyInfoByCompanyId(action,id);
    }

    @Override
    public Observable<Recruit> getRecruitByCompanyId(String action, int id) {
        return mServerAPI.getRecruitByCompanyId(action,id);
    }
}
