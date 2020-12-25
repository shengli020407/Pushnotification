package com.example.pushinformation.retrofitutils.net;

public interface ImpNetWorkInterFace {

    public <T> void get(String url,ImpCallBack<T> callBack);

}
