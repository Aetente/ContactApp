package com.example.guest.contactapp.data.login.web;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.guest.contactapp.Configuration;
import com.example.guest.contactapp.data.dto.Auth;
import com.example.guest.contactapp.data.dto.AuthToken;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Guest on 01.02.2018.
 */

public class LoginWebRepository implements ILoginWeRepository {

    OkHttpClient client;
    Gson gson;

    public LoginWebRepository(OkHttpClient client, Gson gson) {
        this.client = client;
        this.gson = gson;
    }

    @Override
    public void onLogin(@NonNull String email, @NonNull String password, @Nullable ILoginWebRepositoryCallback callback) {
        Auth auth = new Auth(email, password);
        String requestJson = gson.toJson(auth);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, requestJson);
        Request request = new Request.Builder()
                .url(Configuration.BASE_URL+"/login")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onRequestFailure("Connection error!");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String responseJson = response.body().string();
                    AuthToken authToken = gson.fromJson(responseJson,AuthToken.class);
                    if (callback != null) {
                        callback.onRequestSuccess(authToken.getToken());
                    }
                }else if(response.code()==401){
                    if (callback != null) {
                        callback.onRequestFailure("Wrong password");
                    }
                }
                else{
                    if (callback != null) {
                        callback.onRequestFailure("Server error! Call to support!!!");
                    }
                }
            }
        });

    }

    @Override
    public void onRegistration(@NonNull String email, @NonNull String password, @Nullable ILoginWebRepositoryCallback callback) {
        Auth auth = new Auth(email, password);
        String requestJson = gson.toJson(auth);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, requestJson);
        Request request = new Request.Builder()
                .url(Configuration.BASE_URL+"/registration")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onRequestFailure("Connection error!");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String responseJson = response.body().string();
                    AuthToken authToken = gson.fromJson(responseJson,AuthToken.class);
                    if (callback != null) {
                        callback.onRequestSuccess(authToken.getToken());
                    }
                }else if(response.code()==409){
                    if (callback != null) {
                        callback.onRequestFailure("User already exist");
                    }
                }
                else{
                    if (callback != null) {
                        callback.onRequestFailure("Server error! Call to support!!!");
                    }
                }
            }
        });
    }
}
