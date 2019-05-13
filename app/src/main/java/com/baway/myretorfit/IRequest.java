package com.baway.myretorfit;

import com.baway.myretorfit.entity.Goods;
import com.baway.myretorfit.entity.Result;
import com.baway.myretorfit.entity.User;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author dingtao
 * @date 2019/5/13 15:25
 * qq:1940870847
 */
public interface IRequest {

    @FormUrlEncoded
    @POST("user/v1/login")
    Call<Result<User>> login(@Field("phone") String phone, @Field("pwd") String pwd);

    @GET("commodity/v1/findCommodityListByLabel")
    Call<Result<List<Goods>>> findCommodityListByLabel(@Query("labelId") int labelId,
                                                 @Query("page") int page,
                                                 @Query("count") int count);



}
