package com.example.travelapp.api;

import com.example.travelapp.models.LoginResponse;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitClient{
    private static volatile RetrofitClient mInstance = null;
    private Retrofit retrofit;
    private LoginResponse loginResponse;

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }


    private RetrofitClient() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://35.197.153.192:3000/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static RetrofitClient getInstance() {
        if (mInstance == null)
            mInstance = new RetrofitClient();
        return mInstance;
    }
}

