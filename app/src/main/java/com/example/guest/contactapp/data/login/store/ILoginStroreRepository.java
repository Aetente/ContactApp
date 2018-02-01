package com.example.guest.contactapp.data.login.store;

import android.support.annotation.NonNull;

/**
 * Created by Guest on 01.02.2018.
 */

public interface ILoginStroreRepository {
    void saveToken(@NonNull String token);
}
