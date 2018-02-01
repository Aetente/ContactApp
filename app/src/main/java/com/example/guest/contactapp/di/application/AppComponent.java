package com.example.guest.contactapp.di.application;

import com.example.guest.contactapp.di.login.LoginComponent;
import com.example.guest.contactapp.di.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Guest on 01.02.2018.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    LoginComponent plus(LoginModule loginModule);
}
