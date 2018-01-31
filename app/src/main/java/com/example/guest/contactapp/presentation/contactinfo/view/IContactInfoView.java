package com.example.guest.contactapp.presentation.contactinfo.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Guest on 29.01.2018.
 */

public interface IContactInfoView extends MvpView {
    void showProgress();
    void hideProgress();
    void showError(@NonNull String error);
    void showEditMode(@NonNull String email, @NonNull String password, @NonNull String phone, @NonNull String description);
    void showViewMode(@NonNull String email, @NonNull String password, @NonNull String phone, @NonNull String description);
}
