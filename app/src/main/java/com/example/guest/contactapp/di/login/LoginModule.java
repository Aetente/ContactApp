package com.example.guest.contactapp.di.login;

import android.content.Context;

import com.example.guest.contactapp.business.login.ILoginInteractor;
import com.example.guest.contactapp.business.login.LoginInteractor;
import com.example.guest.contactapp.data.login.store.ILoginStroreRepository;
import com.example.guest.contactapp.data.login.store.LoginStoreRepository;
import com.example.guest.contactapp.data.login.web.ILoginWeRepository;
import com.example.guest.contactapp.data.login.web.LoginWebRepository;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Guest on 01.02.2018.
 */

@Module
public class LoginModule {
    @Provides
    @LoginScope
    ILoginStroreRepository provideLoginStoreRep(Context context){
        return new LoginStoreRepository(context);
    }

    @Provides
    @LoginScope
    ILoginWeRepository provideLoginWeRepository(OkHttpClient client, Gson gson){
        return new LoginWebRepository(client,gson);
    }

    @Provides
    @LoginScope
    ILoginInteractor provideLoginInteractor(ILoginWeRepository webRepository, ILoginStroreRepository stroreRepository){
        return new LoginInteractor(webRepository, stroreRepository);
    }
}
