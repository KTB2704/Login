package com.example.login.ui.login;


import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.login.App;
import com.example.login.R;
import com.example.login.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment
            implements LoginContract.View {
    @BindView(R.id.etUserName)
    EditText etUserName;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    LoginPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {

        ((App) requireActivity().getApplication())
                .getComponent()
                .inject(this);

        presenter.attach(this);
    }

    @OnClick(R.id.btnSave)
    void onLoginClick() {
        presenter.login(
                etUserName.getText().toString().trim(),
                etPassword.getText().toString().trim()
        );
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLoginSuccess() {
        Toast.makeText(getContext(),
                "Login success",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detach();
    }
}