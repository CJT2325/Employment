package com.cjt.employment.model.server;

import com.cjt.employment.bean.Recruit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/7/1
 * 邮箱: 445263848@qq.com.
 */
public interface ServerAPI {
    //网站根目录
//    String baseUrl = "http://192.168.1.104:8080/EmploymentService/";
    String baseUrl = "http://www.materialstyle.cn/EmploymentService/";

    //招聘信息
    @GET("servlet/RecruitServlet")
    Observable<Recruit> recruitServlet();

}
