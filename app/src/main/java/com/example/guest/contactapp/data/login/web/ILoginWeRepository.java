package com.example.guest.contactapp.data.login.web;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Guest on 01.02.2018.
 */

public interface ILoginWeRepository {
    void onLogin(@NonNull String email,@NonNull  String password,@Nullable ILoginWebRepositoryCallback callback);
    void onRegistration(@NonNull String email,@NonNull  String password,@Nullable ILoginWebRepositoryCallback callback);
}
