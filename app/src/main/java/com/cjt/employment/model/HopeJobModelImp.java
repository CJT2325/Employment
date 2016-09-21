package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.HopeJobModel;
import com.cjt.employment.model.Imodel.WorkExperienceEditModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/22
 * 邮箱: 445263848@qq.com.
 */
public class HopeJobModelImp implements HopeJobModel{
    private ServerAPI mServerAPI;

    private HopeJobModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static HopeJobModel getInstance() {
        return HopeJobModelHolder.instance;
    }


    private final static class HopeJobModelHolder {
        private final static HopeJobModel instance = new HopeJobModelImp();
    }
    @Override
    public Observable<UpdateResult> updateHopeJob(String action, String id, String hopeposition, String jobtype, String city, String money, String content) {
        return mServerAPI.updateHopeJob(action,id,hopeposition,jobtype,city,money,content);
    }
}
