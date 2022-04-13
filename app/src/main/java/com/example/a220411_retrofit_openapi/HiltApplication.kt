package com.example.a220411_retrofit_openapi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

//Application 클래스에 필수적으로 적용해야함.
@HiltAndroidApp
class HiltApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

    }
}