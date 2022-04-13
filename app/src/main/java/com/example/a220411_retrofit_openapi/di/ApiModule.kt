package com.example.a220411_retrofit_openapi.di

import androidx.databinding.ktx.BuildConfig
import com.example.a220411_retrofit_openapi.network.ApiRetrofit
import com.example.a220411_retrofit_openapi.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    //InterCepter Log용
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        //위에서 정의한 OkHttp InterCepter를 생성자 주입으로 입력 후
        //Retrofit 객체를 생성
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //최종적으로 Retrofit 객체를 사용할 때 사용하는 메서드
    //Retrofit 통신을 위한 Api 객체를 반환
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiRetrofit {
        return retrofit.create(ApiRetrofit::class.java)
    }


}