package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/21
 * 邮箱: 445263848@qq.com.
 */
public interface RecruitmentInfoModel {
    public Observable<RecruitmentInfo> getRecruitInfoById(String action, int id);
}
