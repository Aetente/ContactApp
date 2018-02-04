package com.example.guest.contactapp.presentation.contactlist.view;

import android.support.annotation.NonNull;

import com.example.guest.contactapp.presentation.contactlist.viewmodels.ContactViewModel;

import java.util.List;

/**
 * Created by Guest on 04.02.2018.
 */

public class ContactListView implements IContactListView {



    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(@NonNull String error) {

    }

    @Override
    public void showContactInfoView(@NonNull String status) {

    }

    @Override
    public void updateList(@NonNull List<ContactViewModel> contacts) {

    }

    @Override
    public void showEmptyListMsg() {

    }

    @Override
    public void makeLogout() {

    }
}
