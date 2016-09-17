package com.cjt.employment.model;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.UserInfoModel;
import com.cjt.employment.model.Imodel.VitageUserEditModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/10
 * 邮箱: 445263848@qq.com.
 */
public class VitageUserEditModelImp implements VitageUserEditModel {
    private ServerAPI mServerAPI;

    private VitageUserEditModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static VitageUserEditModel getInstance() {
        return VitageUserEditModelHolder.instance;
    }


    private final static class VitageUserEditModelHolder {
        private final static VitageUserEditModel instance = new VitageUserEditModelImp();
    }

    @Override
    public Observable<UpdateResult> updateVitageUser(String action, String id, String name, String sex, String brithday, String education, String worktime, String phone, String email, String city) {
        return mServerAPI.updateVitageUser(action, id, name, sex, brithday, education, worktime, phone, email, city);
    }
}
