package com.example.login;

import android.app.Application;

import com.example.login.di.AppComponent;
import com.example.login.di.AppModule;
import com.example.login.di.NetworkModule;

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
