package com.example.login.base;

public abstract class BasePresenterImpl<V>
        implements BasePresenter<V> {

    protected V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }

    protected boolean isViewAttached() {
        return view != null;
    }
}
