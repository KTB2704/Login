package com.example.login.ui.login;

import com.example.login.base.BasePresenter;
import com.example.login.base.BaseView;

public interface LoginContract {

    interface View extends BaseView{
        void onLoginSuccess();
    }

    interface Presenter extends BasePresenter<View>{
        void login(String username, String password);
    }
}
