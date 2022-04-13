package com.example.a220411_retrofit_openapi.domain.repository

import com.example.a220411_retrofit_openapi.network.ApiRetrofit
import com.example.a220411_retrofit_openapi.util.Constants
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val apiRetrofit: ApiRetrofit) {

    suspend fun checkSMS(param1: String, param2: String) =
        apiRetrofit.onCheckSMS(param1, param2)

    suspend fun boxOfficeApi(targetDt: String) =
        apiRetrofit.getBoxOffice(Constants.API_KEY, targetDt)


    suspend fun postModel(id: String, pwd: String, nick: String) =
        apiRetrofit.post_users(id, pwd, nick)
}
