package com.cjt.employment.model;

import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.CompanyProject;
import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.bean.UpLoadImageResult;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.EnterpriseInfoModel;
import com.cjt.employment.model.Imodel.EnterprisePositionModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
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

    @Override
    public Observable<UpLoadImageResult> uploadImage(String action, int id, File file) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        return mServerAPI.upload(action, id, requestBody);
    }

    @Override
    public Observable<UpdateResult> updateCompanyNameById(String action, String name, String id) {
        return mServerAPI.updateCompanyNameById(action,name,id);
    }
    @Override
    public Observable<UpdateResult> updateCompanyConditionById(String action, String financing, String pattern, String startnumber, String endnumber, String id) {
        return mServerAPI.updateCompanyConditionById(action,financing,pattern,startnumber,endnumber,id);
    }

    @Override
    public Observable<CompanyDescpt> getCompanyControduceById(String action, String id) {
        return mServerAPI.getCompanyControduceById(action,id);
    }

    @Override
    public Observable<UpdateResult> updateCompanyControduceById(String action, String id, String content) {
        return mServerAPI.updateCompanyControduceById(action,id,content);
    }

    @Override
    public Observable<CompanyProject> getProjectControduceById(String action, String id) {
        return mServerAPI.getProjectControduceById(action,id);
    }

    @Override
    public Observable<UpdateResult> updateProjectControduceById(String action, String id, String content) {
        return mServerAPI.updateProjectControduceById(action,id,content);
    }
}
