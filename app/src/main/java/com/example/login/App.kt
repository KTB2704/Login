package com.example.login

import android.app.Application
import com.example.login.di.AppComponent
import com.example.login.di.AppModule
import com.example.login.di.DaggerAppComponent
import com.example.login.di.NetworkModule

class App : Application() {
    var component: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()
    }
}