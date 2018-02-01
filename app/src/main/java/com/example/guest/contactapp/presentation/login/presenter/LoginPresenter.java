package com.example.guest.contactapp.presentation.login.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.guest.contactapp.business.login.ILoginInteractor;
import com.example.guest.contactapp.business.login.ILoginInteractorCallback;
import com.example.guest.contactapp.business.login.InteractorEmailException;
import com.example.guest.contactapp.business.login.InteractorPasswordException;
import com.example.guest.contactapp.presentation.login.view.ILoginView;

/**
 * Created by Guest on 31.01.2018.
 */
@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements ILoginPresenter, ILoginInteractorCallback {

    ILoginInteractor mInteractor;
    private Handler handler;

    public LoginPresenter() {
        handler = new Handler();
    }

    @Override
    public void actionLogin(@NonNull String email, @NonNull String password) {
        getViewState().clearError();
        getViewState().showProgress();
        try {
            mInteractor.onLogin(email, password, this);
        } catch (InteractorEmailException e) {
            e.printStackTrace();
            getViewState().putEmailError(e.getMessage());
        } catch (InteractorPasswordException e) {
            e.printStackTrace();
            getViewState().putPasswordError(e.getMessage());
        }
    }

    @Override
    public void actionRegistration(@NonNull String email, @NonNull String password) {
        getViewState().clearError();
        getViewState().showProgress();
        try {
            mInteractor.onRegistration(email, password, this);
        } catch (InteractorEmailException e) {
            e.printStackTrace();
            getViewState().putEmailError(e.getMessage());
        } catch (InteractorPasswordException e) {
            e.printStackTrace();
            getViewState().putPasswordError(e.getMessage());
        }
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


    @Override
    public void onLoginSucces() {
        handler.post(() -> handleLoginSucces());
    }

    @Override
    public void onRegistrationSucces() {
        handler.post(() -> handleRegSucces());
    }

    @Override
    public void onError(String error) {
        handler.post(() -> handleError(error));
    }
}
