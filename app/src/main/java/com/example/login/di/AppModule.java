package com.example.login.di;

import android.app.Application;
import android.content.Context;

import com.example.login.utils.SharedPrefManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application app;

    public AppModule(Application app){
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return app;
    }

    @Provides
    @Singleton
    SharedPrefManager provideSharedPrefManager(Context context) {
        return new SharedPrefManager(context);
    }
}
