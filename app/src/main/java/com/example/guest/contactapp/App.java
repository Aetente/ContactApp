package com.example.guest.contactapp;

import android.app.Application;

import com.example.guest.contactapp.di.application.AppComponent;
import com.example.guest.contactapp.di.application.AppModule;
import com.example.guest.contactapp.di.application.DaggerAppComponent;
import com.example.guest.contactapp.di.login.LoginComponent;
import com.example.guest.contactapp.di.login.LoginModule;

/**
 * Created by Guest on 01.02.2018.
 */

public class App extends Application{
    private AppComponent appComponent;
    private LoginComponent loginComponent;

    private static App app;
    public static App get(){
        return app;
    }

    @Override
    public void onCreate() {
        app = this;
        appComponent = prepare();
        super.onCreate();
    }

    private AppComponent prepare(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public LoginComponent plusLoginModule(LoginModule loginModule){
        if(loginComponent==null){
            loginComponent = appComponent.plus(loginModule);
        }
        return loginComponent;
    }

    public void clearLoginComponent(){
        loginComponent = null;
    }
}
