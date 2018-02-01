package com.example.guest.contactapp.presentation.login.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Guest on 29.01.2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface ILoginView extends MvpView{
    void showProgress();
    void hideProgress();
    void onLoginSucces(@NonNull String message);
    void showError(@NonNull String error);
    void hideErrorDialog();
}
