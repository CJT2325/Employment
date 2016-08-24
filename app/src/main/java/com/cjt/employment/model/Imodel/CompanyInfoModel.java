package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.Recruit;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/24
 * 邮箱: 445263848@qq.com.
 */
public interface CompanyInfoModel {
    //获取公司详细信息
    public Observable<CompanyInfo> getCompanyInfoByCompanyId(String action, int id);
    //获取公司发布的职位
    public Observable<Recruit> getRecruitByCompanyId(String action, int id);
}
