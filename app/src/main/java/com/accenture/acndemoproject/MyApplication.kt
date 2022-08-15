package com.accenture.acndemoproject

import android.app.Application
import com.accenture.acndemoapplication.di.ApplicationComponent
import com.accenture.acndemoapplication.di.DaggerApplicationComponent

class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .build()
    }
}