package com.example.guest.contactapp.presentation.contactinfo.presenter;

import android.support.annotation.NonNull;

/**
 * Created by Guest on 29.01.2018.
 */

public interface IContactInfoPresenter {
    void actionEdit(@NonNull String email, @NonNull String password, @NonNull String phone, @NonNull String description);
    void actionDone(@NonNull String email, @NonNull String password, @NonNull String phone, @NonNull String description);
}
