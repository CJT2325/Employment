package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/21
 * 邮箱: 445263848@qq.com.
 */
public interface RecruitmentInfoModel {
    public Observable<RecruitmentInfo> getRecruitInfoById(String action, int id);

    public Observable<UpdateResult> pushVitage(String action, String id, int recruitId, int companyId);

    public Observable<UpdateResult> addCollection(String action, String id, String recruitId);

    public Observable<UpdateResult> isCollection(String action, String id, String recruitId);

    public Observable<UpdateResult> deleteCollection(String action, String id, String recruitid);
}
