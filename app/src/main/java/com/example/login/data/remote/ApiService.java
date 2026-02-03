package com.example.login.data.remote;

import com.example.login.data.model.LoginRequest;
import com.example.login.data.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/login")
    Call<LoginResponse> login(@Body LoginRequest request);
}
