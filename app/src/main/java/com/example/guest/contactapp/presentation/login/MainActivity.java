package com.example.guest.contactapp.presentation.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.contactapp.R;
import com.example.guest.contactapp.presentation.login.view.LoginView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.hold_all, new LoginView())
                    .commit();
        }
    }

}
