package com.cjt.employment.model.server;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.HopeJob;
import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.bean.UpLoadImageResult;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.WorkExperience;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    String baseUrl = "http://172.16.101.37:8080/EmploymentService/";
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

    //获取用户信息
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

    //更新用户姓名
    @GET("servlet/AccountServlet")
    Observable<UpLoadImageResult> updateName(@Query("action") String action, @Query("id") int id, @Query("name") String name);

    //获取用户信息
    @FormUrlEncoded
    @POST("servlet/LoginServlet")
    Observable<LoginResult> login(@Query("action") String action, @Field("phone") String id, @Field("password") String password);

    //获取用户头像
    @GET("servlet/LoginServlet")
    Observable<AccountInfo> getUserCover(@Query("action") String action, @Query("id") String id);

    //更新简历基本信息
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> updateVitageUser(
            @Query("action") String action,
            @Query("id") String id,
            @Query("name") String name,
            @Query("sex") String sex,
            @Query("brithday") String brithday,
            @Query("education") String education,
            @Query("worktime") String worktime,
            @Query("phone") String phone,
            @Query("email") String email,
            @Query("city") String city
    );

    //获取简历基本信息
    @GET("servlet/VitageServlet")
    Observable<VitageBean> getVitageUser(
            @Query("action") String action,
            @Query("id") String id
    );

    //添加工作经历
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> addWorkExperience(
            @Query("action") String action,
            @Query("id") String id,
            @Query("companyname") String companyname,
            @Query("position") String position,
            @Query("starttime") String starttime,
            @Query("endtime") String endtime,
            @Query("content") String content
    );
    //获取工作经历
    @GET("servlet/VitageServlet")
    Observable<WorkExperience> getWorkExperienceList(
            @Query("action") String action,
            @Query("id") String id
    );
    //添加教育经历
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> addEducation(
            @Query("action") String action,
            @Query("id") String id,
            @Query("schoolname") String schoolname,
            @Query("major") String major,
            @Query("graduationtime") String graduationtime,
            @Query("education") String education
    );
    //获取教育经历
    @GET("servlet/VitageServlet")
    Observable<Education> getEducationList(
            @Query("action") String action,
            @Query("id") String id
    );
    //获取期望工作
    @GET("servlet/VitageServlet")
    Observable<HopeJob> getHopeJob(
            @Query("action") String action,
            @Query("id") String id
    );

    //更新期望工作
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> updateHopeJob(
            @Query("action") String action,
            @Query("id") String id,
            @Query("hopeposition") String hopeposition,
            @Query("jobtype") String jobtype,
            @Query("city") String city,
            @Query("money") String money,
            @Query("content") String content
    );

}
