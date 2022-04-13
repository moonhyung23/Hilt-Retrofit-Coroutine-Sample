package com.example.a220411_retrofit_openapi.network

import com.example.a220411_retrofit_openapi.domain.model.BoxOfficeResult
import com.example.a220411_retrofit_openapi.domain.model.PostModel
import com.example.a220411_retrofit_openapi.domain.model.Result
import com.example.a220411_retrofit_openapi.util.Constants
import retrofit2.Response
import retrofit2.http.*


interface ApiRetrofit {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOffice(
        @Query("key") key: String?,
        @Query("targetDt") targetDt: String?,
    ): Response<Result>

    @FormUrlEncoded
    @POST("actCheckSms")
    suspend fun onCheckSMS(
        @Field("telno") num: String,
        @Field("randomNumber") randNumber: String,
    ): Response<PostModel>

    @FormUrlEncoded
    @POST(Constants.Example_url)
    @Headers(
        "accept: application/json",
        "content-type: application/x-www-form-urlencoded; charset=utf-8"
    )


    //post로 서버에 데이터를 보내는 메서드
    suspend fun post_users(
        // 서버에 Post방식으로 보낼 떄 사용하는  파라미터의 키 값
        //ex)@Field('키') =>  $_POST['키']
        @Field("id") nick: String,
        @Field("nick") pwd: String,
        @Field("pwd") id: String,
    ): Response<PostModel>

}