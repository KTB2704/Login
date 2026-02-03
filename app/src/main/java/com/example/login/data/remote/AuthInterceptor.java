package com.example.login.data.remote;

import com.example.login.utils.SharedPrefManager;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private final SharedPrefManager pref;

    @Inject
    public AuthInterceptor(SharedPrefManager pref) {
        this.pref = pref;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        String token = pref.getAccessToken();

        Request.Builder builder = original.newBuilder();

        if (token != null) {
            builder.addHeader("Authorization", "Bearer " + token);
        }

        return chain.proceed(builder.build());
    }
}
