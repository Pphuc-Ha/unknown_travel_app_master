package com.example.travelapp.api;

import com.example.travelapp.models.LoginRequest;
import com.example.travelapp.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("/user/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

}
