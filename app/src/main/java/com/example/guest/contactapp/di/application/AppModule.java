package com.example.guest.contactapp.di.application;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Guest on 01.02.2018.
 */

@Module
public class AppModule {
    private final Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return  appContext;
    }
}
