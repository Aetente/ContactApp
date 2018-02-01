package com.example.guest.contactapp.data.login.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.guest.contactapp.Configuration;

/**
 * Created by Guest on 01.02.2018.
 */

public class LoginStoreRepository implements ILoginStroreRepository {

    Context context;

    public LoginStoreRepository(Context context){
        this.context = context;
    }

    @Override
    public void saveToken(@NonNull String token) {
        SharedPreferences sharedPreference = context.getSharedPreferences(Configuration.AUTH_SP,Context.MODE_PRIVATE);
        sharedPreference
                .edit()
                .putString(Configuration.TOKEN_KEY, token)
                .commit();
    }
}
