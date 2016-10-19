package com.cjt.employment.model;

import com.cjt.employment.bean.CompanyPosition;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.EditCompanyPositionModel;
import com.cjt.employment.model.Imodel.EducationEditModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/19
 * 邮箱: 445263848@qq.com.
 */
public class EditCompanyPositionModelImp implements EditCompanyPositionModel {
    private ServerAPI mServerAPI;

    private EditCompanyPositionModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static EditCompanyPositionModel getInstance() {
        return EditCompanyPositionModelHolder.instance;
    }


    private final static class EditCompanyPositionModelHolder {
        private final static EditCompanyPositionModel instance = new EditCompanyPositionModelImp();
    }

    @Override
    public Observable<UpdateResult> addCompanyPosition(String action, String id, String position, String type, String education, String number, String startwarge, String endwarge, String startworktime, String endworktime, String city, String address, String content) {
        return mServerAPI.addCompanyPosition(action, id, position, type, education, number, startwarge, endwarge, startworktime, endworktime, city, address, content);
    }

    @Override
    public Observable<CompanyPosition> getCompanyPositionById(String action, String id) {
        return mServerAPI.getCompanyPositionById(action,id);
    }
}
