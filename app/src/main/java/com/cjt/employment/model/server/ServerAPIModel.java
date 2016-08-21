package com.cjt.employment.model.server;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/4/8.
 */
public class ServerAPIModel {
    public final static ServerAPI provideServerAPI(OkHttpClient okHttpClient){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ServerAPI.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(ServerAPI.class);
    }

    public final static OkHttpClient provvideOkHttpClient(){
        OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new HeaderInterceptors());
        return okHttpClient.build();
    }
}
