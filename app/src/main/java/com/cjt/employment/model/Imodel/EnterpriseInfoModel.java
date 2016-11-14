package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.CompanyProject;
import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.bean.UpLoadImageResult;
import com.cjt.employment.bean.UpdateResult;

import java.io.File;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/16
 * 邮箱: 445263848@qq.com.
 */
public interface EnterpriseInfoModel {
    public Observable<CompanyInfo> getEnterpriseInfo(String action, String id);
    public Observable<UpLoadImageResult> uploadImage(String action, int id, File file);
    public Observable<UpdateResult> updateCompanyNameById(String action, String name, String id);
    public Observable<UpdateResult> updateCompanyConditionById(String action, String financing, String pattern, String startnumber, String endnumber, String id);
    public Observable<CompanyDescpt>  getCompanyControduceById(String action, String id);
    public Observable<UpdateResult>  updateCompanyControduceById(String action, String id,String content);

    public Observable<CompanyProject>  getProjectControduceById(String action, String id);
    public Observable<UpdateResult>  updateProjectControduceById(String action, String id,String content);

}
