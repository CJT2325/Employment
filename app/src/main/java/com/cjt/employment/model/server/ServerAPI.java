package com.cjt.employment.model.server;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.bean.UpLoadImageResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/7/1
 * 邮箱: 445263848@qq.com.
 */
public interface ServerAPI {
    //网站根目录
    String baseUrl = "http://192.168.1.104:8080/EmploymentService/";
//    String baseUrl = "http://www.materialstyle.cn/EmploymentService/";

    //招聘信息
    @GET("servlet/RecruitServlet")
    Observable<Recruit> recruitServlet(@Query("action") String action);

    //职位详情
    @GET("servlet/RecruitServlet")
    Observable<RecruitmentInfo> getRecruitInfoByID(@Query("action") String action, @Query("id") int id);

    //公司详情
    @GET("servlet/CompanyServlet")
    Observable<CompanyInfo> getCompanyInfoByCompanyId(@Query("action") String action, @Query("id") int id);

    //公司发布的职位
    @GET("servlet/CompanyServlet")
    Observable<Recruit> getRecruitByCompanyId(@Query("action") String action, @Query("id") int id);

    //公司发布的职位
    @GET("servlet/AccountServlet")
    Observable<AccountInfo> getAccountInfoById(@Query("action") String action, @Query("id") int id);

    //上传图片
    @Multipart
    @POST("servlet/ImageUpLoadServlet")
    Observable<UpLoadImageResult> upload(
            @Query("action") String name,
            @Query("id") int id,
            @Part("file\"; filename=\"image.jpg") RequestBody imgs
    );
}
