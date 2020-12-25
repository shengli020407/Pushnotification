package com.example.pushinformation.retrofitutils.net;

public interface ImpCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String error);
}
