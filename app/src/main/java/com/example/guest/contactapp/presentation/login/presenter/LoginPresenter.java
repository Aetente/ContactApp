package com.example.guest.contactapp.presentation.login.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.guest.contactapp.presentation.login.view.ILoginView;

/**
 * Created by Guest on 31.01.2018.
 */
@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements ILoginPresenter {

    public LoginPresenter() {
        getViewState().showError("Error");
    }

    @Override
    public void actionLogin(@NonNull String email, @NonNull String password) {
        getViewState().showProgress();
        //todo send request to server
    }

    @Override
    public void actionRegistration(@NonNull String email, @NonNull String password) {
        getViewState().showProgress();
        //todo send request to server
    }

    @Override
    public void onErrorDialogDissmiss() {
        getViewState().hideErrorDialog();
    }

    private void handleLoginSucces(){
        getViewState().hideProgress();
        getViewState().onLoginSucces("login succes");
    }

    private void handleError(String error){
        getViewState().hideProgress();
        getViewState().showError(error);
    }


    private void handleRegSucces(){
        getViewState().hideProgress();
        getViewState().onLoginSucces("registration succes");
    }


}
