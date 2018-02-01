package com.example.guest.contactapp.business.login;

/**
 * Created by Guest on 01.02.2018.
 */

public interface ILoginInteractorCallback {
    void onLoginSucces();
    void onRegistrationSucces();
    void onError(String error);
}
