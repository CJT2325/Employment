package com.cjt.employment.model;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.Imodel.RecruitmentInfoModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;
import com.cjt.employment.ui.activity.RecruitmentInfoActivity;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/21
 * 邮箱: 445263848@qq.com.
 */
public class RecruitmentInfoModelImp implements RecruitmentInfoModel {
    private ServerAPI mServerAPI;

    private RecruitmentInfoModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static RecruitmentInfoModel getInstance() {
        return RecruitmentInfoModelHolder.instance;
    }

    private final static class RecruitmentInfoModelHolder {
        private final static RecruitmentInfoModel instance = new RecruitmentInfoModelImp();
    }

    @Override
    public Observable<RecruitmentInfo> getRecruitInfoById(String action, int id) {
        return mServerAPI.getRecruitInfoByID(action, id);
    }

    @Override
    public Observable<UpdateResult> pushVitage(String action, String id, int recruitId, int companyId) {
        return mServerAPI.pushVitage(action, id, recruitId, companyId);
    }
}
