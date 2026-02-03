package com.example.login.ui.login;

import com.example.login.base.BasePresenterImpl;
import com.example.login.data.model.LoginRequest;
import com.example.login.data.model.LoginResponse;
import com.example.login.data.remote.ApiService;
import com.example.login.utils.SharedPrefManager;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter
        extends BasePresenterImpl<LoginContract.View>
        implements LoginContract.Presenter
{
    private final ApiService api;
    private final SharedPrefManager pref;

    @Inject
    public LoginPresenter(ApiService api, SharedPrefManager pref){
        this.api = api;
        this.pref = pref;
    }

    @Override
    public void login(String username, String password) {
        if (!isViewAttached()) return;

        view.showLoading();

        Call<LoginResponse> call =
                api.login(new LoginRequest(username, password));

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!isViewAttached()) return;

                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {

                    LoginResponse data = response.body();

                    pref.saveAuth(
                            data.getAccessToken(),
                            data.getRefreshToken(),
                            data.getUser().getUsername(),
                            data.getUser().getEmail()
                    );

                    view.onLoginSuccess();
                }
                else{
                    view.showError("Login failed");
                }
        }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                if (!isViewAttached()) return;

                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
    }
}
