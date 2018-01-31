package com.example.guest.contactapp.presentation.contactlist.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.example.guest.contactapp.presentation.contactlist.viewmodels.ContactViewModel;

import java.util.List;

/**
 * Created by Guest on 29.01.2018.
 */

public interface IContactListView extends MvpView {
    void showProgress();
    void hideProgress();
    void showError(@NonNull String error);
    void showContactInfoView(@NonNull String status);
    void updateList(@NonNull List<ContactViewModel> contacts);
    void showEmptyListMsg();
    void makeLogout();
}
