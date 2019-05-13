package com.baway.myretorfit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author dingtao
 * @date 2019/5/13 15:19
 * qq:1940870847
 */
public class RetrofitUtil {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.17.8.100/small/")
            .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
            .build();


}
