package com.baway.myretorfit.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/5/13 19:40
 * @Description：描述信息
 */
public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.e("LogInterceptor", "request:" + request);
        Log.e("LogInterceptor", "System.nanoTime():" + System.nanoTime());
        Response response = chain.proceed(request);
        Log.e("LogInterceptor", "request:" + request);
        Log.e("LogInterceptor", "System.nanoTime():" + System.nanoTime());
        return response;
    }

}
