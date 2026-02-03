package com.example.login.base;

public interface BasePresenter<V> {
    void attach(V view);
    void detach();
}
