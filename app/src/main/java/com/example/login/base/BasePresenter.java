package com.example.login.base;

public interface BasePresenter<T> {
    void attach(T view);
    void dettach();
}
