package com.cjt.employment.model.server;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/4/8.
 */
public class HeaderInterceptors implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
//        if (API_KEY!=null){
//            request=request.newBuilder()
//                    .header("apikey",API_KEY)
//                    .build();
//        }
        return chain.proceed(request);
    }

}
