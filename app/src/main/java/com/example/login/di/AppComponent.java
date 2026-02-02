package com.example.login.di;

import com.example.login.ui.login.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(LoginFragment fragment);
}
