package com.example.guest.contactapp.data.login.web;

import android.support.annotation.NonNull;

/**
 * Created by Guest on 01.02.2018.
 */

public interface ILoginWebRepositoryCallback {
    void onRequestSuccess(@NonNull String token);
    void onRequestFailure(@NonNull String error);
}
