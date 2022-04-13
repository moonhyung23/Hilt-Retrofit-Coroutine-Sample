package com.example.a220411_retrofit_openapi.domain.repository

import com.example.a220411_retrofit_openapi.util.ApiResult
import com.example.a220411_retrofit_openapi.util.Constants
import retrofit2.Response

//리파지토리를 상속함으로 Retrofit Api 호출에 대한 보일러플레이트 코드를 줄일 수 있음.
open class BaseRepository {
    suspend fun <T> getResponse(response: Response<T>): ApiResult<T> {
        return try {
            if (response.isSuccessful) {
                return ApiResult.success("000000", response.body())
            } else {
                val code = response.headers()[Constants.RESULT_CODE] ?: ""
                val message = response.headers()[Constants.RESULT_MESSAGE] ?: ""
                ApiResult.error(code, message)
            }
        } catch (e: Exception) {
            ApiResult.error(e)
        }
    }
}