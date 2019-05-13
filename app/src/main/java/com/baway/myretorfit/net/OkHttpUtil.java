package com.baway.myretorfit.net;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/5/13 19:42
 * @Description：描述信息
 */
public class OkHttpUtil {


    private static OkHttpUtil instance;
    private OkHttpClient okHttpClient;

    private OkHttpUtil(){

        //自定义拦截器
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .build();

    }

    public static OkHttpUtil getInstance() {
        if (instance == null){
            instance = new OkHttpUtil();
        }
        return instance;
    }

}
