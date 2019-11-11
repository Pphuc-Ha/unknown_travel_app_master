package com.example.travelapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelapp.R;
import com.example.travelapp.api.Api;
import com.example.travelapp.api.RetrofitClient;
import com.example.travelapp.models.LoginRequest;
import com.example.travelapp.models.LoginResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmailPhone, editTextPassword;
    Button btnLogin, btnSignup;
    Api api;
    TextView textViewForgotPassword;
    LoginRequest loginRequest;
    LoginResponse loginResponse;
    SharedPreferences shared;
    Intent intentToListTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnSignup = (Button)findViewById(R.id.btnSignup);
        editTextEmailPhone=(EditText)findViewById(R.id.editTextEmailPhone);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        api = RetrofitClient.getInstance().getRetrofit().create(Api.class);

        shared = getSharedPreferences("token login" , MODE_PRIVATE);
        loginResponse = loadTokenLogin();

        if (loginResponse != null) {
            intentToListTour = new Intent(this, ListTourActivity.class);
            intentToListTour.putExtra("token", loginResponse.getToken());
            startActivity(intentToListTour);
        }


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                    sendLoginRequest(loginRequest);
                }
            }
        });
    }


    private void sendLoginRequest(LoginRequest loginRequest) {
        api = RetrofitClient.getInstance().getRetrofit().create(Api.class);
        Call<LoginResponse> call = api.login(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                //If Success(200 - OK)
                if (response.code() == 200) {
                    loginResponse = new LoginResponse(response.body());
                    RetrofitClient.getInstance().setLoginResponse(loginResponse);
                    saveLoginResponse(loginResponse);
                }
                if (response.code() == 400) {
                    Toast.makeText(MainActivity.this, "Email/Phone - mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    private boolean checkData() {
        String emailphone, password;
        emailphone = editTextEmailPhone.getText().toString();
        password = editTextPassword.getText().toString();
        if (emailphone.length() < 1) {
            editTextEmailPhone.setError("UserName Không được rỗng");
            return false;
        }
        if (password.length() < 1) {
            editTextPassword.setError("Password không được rỗng");
            return false;
        }
        loginRequest = new LoginRequest(emailphone, password);
        return true;
    }

    private  void saveLoginResponse(LoginResponse loginResponse){
        SharedPreferences.Editor editor = shared.edit();
        Gson gson = new Gson();
        String json = gson.toJson(loginResponse);
        editor.putString("token login", json);
        editor.apply();
    }

    private  LoginResponse loadTokenLogin(){
        Gson gson = new Gson();
        String json = shared.getString("token login", null);
        if (json != null) {
            LoginResponse loginResponse;
            loginResponse = gson.fromJson(json, LoginResponse.class);
            return loginResponse;
        } else
            return null;
    }
}
