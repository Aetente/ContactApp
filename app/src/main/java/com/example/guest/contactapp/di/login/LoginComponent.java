package com.example.guest.contactapp.di.login;

import com.example.guest.contactapp.presentation.login.presenter.LoginPresenter;

import dagger.Subcomponent;

/**
 * Created by Guest on 01.02.2018.
 */

@Subcomponent(modules = {LoginModule.class})
@LoginScope
public interface LoginComponent {
    void inject(LoginPresenter loginPresenter);
}
