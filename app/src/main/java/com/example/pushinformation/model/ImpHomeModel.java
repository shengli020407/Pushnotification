package com.example.pushinformation.model;

import com.example.pushinformation.contract.HomeFragmentContract;
import com.example.pushinformation.retrofitutils.net.ImpCallBack;
import com.example.pushinformation.retrofitutils.net.Utils;

public class ImpHomeModel implements HomeFragmentContract.HomeModel {

    private HomeFragmentContract.HomePresenter presenter;

    public ImpHomeModel(HomeFragmentContract.HomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void HomeModel(String url, ImpCallBack<T> callBack) {
        Utils.getUtils().get(url,callBack);
    }
}
