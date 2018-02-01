package com.example.guest.contactapp.business.login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.guest.contactapp.data.login.store.ILoginStroreRepository;
import com.example.guest.contactapp.data.login.web.ILoginWeRepository;
import com.example.guest.contactapp.data.login.web.ILoginWebRepositoryCallback;

/**
 * Created by Guest on 01.02.2018.
 */

public class LoginInteractor implements ILoginInteractor{

    ILoginWeRepository weRepository;
    ILoginStroreRepository stroreRepository;

    public LoginInteractor(ILoginWeRepository weRepository, ILoginStroreRepository stroreRepository) {
        this.weRepository = weRepository;
        this.stroreRepository = stroreRepository;
    }

    @Override
    public void onLogin(@NonNull String email, @NonNull String password, @Nullable ILoginInteractorCallback callback) throws InteractorEmailException, InteractorPasswordException {
        if(!isEmailValid(email)){
            throw new InteractorEmailException("Email should contain @");
        }
        if(!isPasswordValid(password)){
            throw new InteractorPasswordException("Password min symbols is 4");
        }

        weRepository.onLogin(email, password, new ILoginWebRepositoryCallback() {
            @Override
            public void onRequestSuccess(@NonNull String token) {
                stroreRepository.saveToken(token);
                if(callback!=null) {
                    callback.onLoginSucces();
                }
            }

            @Override
            public void onRequestFailure(@NonNull String error) {
                if(callback!=null) {
                    callback.onError(error);
                }
            }
        });
    }

    @Override
    public void onRegistration(@NonNull String email, @NonNull String password, @Nullable ILoginInteractorCallback callback) throws InteractorEmailException, InteractorPasswordException {
        if(!isEmailValid(email)){
            throw new InteractorEmailException("Email should contain @");
        }
        if(!isPasswordValid(password)){
            throw new InteractorPasswordException("Password min symbols is 4");
        }

        weRepository.onRegistration(email, password, new ILoginWebRepositoryCallback() {
            @Override
            public void onRequestSuccess(@NonNull String token) {
                stroreRepository.saveToken(token);
                if(callback!=null) {
                    callback.onLoginSucces();
                }
            }

            @Override
            public void onRequestFailure(@NonNull String error) {
                if(callback!=null) {
                    callback.onError(error);
                }
            }
        });
    }

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPasswordValid(String password){
        return password.length() >= 4;
    }
}
