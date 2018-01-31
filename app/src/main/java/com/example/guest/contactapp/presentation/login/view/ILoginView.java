package com.example.guest.contactapp.presentation.login.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Guest on 29.01.2018.
 */

public interface ILoginView extends MvpView{
    void showProgress();
    void hideProgress();
    void onLoginSucces(@NonNull String message);
    void showError(@NonNull String error);
}
