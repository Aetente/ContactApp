package com.example.guest.contactapp.presentation.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.guest.contactapp.R;
import com.example.guest.contactapp.presentation.login.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Guest on 31.01.2018.
 */

public class LoginView extends MvpAppCompatFragment implements ILoginView {
    private Unbinder mUnbinder;
    EditText mInputEmail, mInputPassword;
    Button mRegBtn, mLoginBtn;
    ProgressBar mMyProgress;

    @InjectPresenter
    LoginPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_view,container,false);
        mUnbinder = ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.login_btn)
    void onLoginClick(){
        presenter.actionLogin(mInputEmail.getText().toString(),mInputPassword.getText().toString());
    }
    @OnClick(R.id.reg_btn)
    void onRegClick(){
        presenter.actionRegistration(mInputEmail.getText().toString(),mInputPassword.getText().toString());
    }


    @Override
    public void showProgress() {
        mMyProgress.setVisibility(View.VISIBLE);
        mInputEmail.setVisibility(View.INVISIBLE);
        mInputPassword.setVisibility(View.INVISIBLE);
        mLoginBtn.setVisibility(View.INVISIBLE);
        mRegBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {

        mMyProgress.setVisibility(View.INVISIBLE);
        mInputEmail.setVisibility(View.VISIBLE);
        mInputPassword.setVisibility(View.VISIBLE);
        mLoginBtn.setVisibility(View.VISIBLE);
        mRegBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoginSucces(@NonNull String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        //todo replace to contactlistview
    }

    @Override
    public void showError(@NonNull String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
        //todo alert dialog
    }


    @Override
    public void onDestroyView() {

        super.onDestroyView();
        int i =0;
        mUnbinder.unbind();
    }
}
