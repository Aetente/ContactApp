package com.example.guest.contactapp.presentation.login.presenter;

import android.support.annotation.NonNull;

/**
 * Created by Guest on 29.01.2018.
 */

public interface ILoginPresenter {
    void actionLogin(@NonNull String email,@NonNull String password);
    void actionRegistration(@NonNull String email,@NonNull String password);
    void onErrorDialogDissmiss();

}
