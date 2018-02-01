package com.example.guest.contactapp.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Guest on 01.02.2018.
 */

public class AuthToken {
    @SerializedName("token")
    @Expose
    private  String token;

    public AuthToken(){}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthToken(String token) {

        this.token = token;
    }
}
