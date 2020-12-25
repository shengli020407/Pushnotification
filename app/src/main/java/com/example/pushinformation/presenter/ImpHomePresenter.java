package com.example.pushinformation.presenter;

import com.example.pushinformation.base.BasePresenter;
import com.example.pushinformation.bean.HomeFragmentBean;
import com.example.pushinformation.contract.HomeFragmentContract;
import com.example.pushinformation.model.ImpHomeModel;
import com.example.pushinformation.retrofitutils.net.ImpCallBack;
import com.example.pushinformation.retrofitutils.net.Urlconstant;
import com.example.pushinformation.retrofitutils.net.Utils;

public class ImpHomePresenter extends BasePresenter<HomeFragmentContract.HomeView , HomeFragmentContract.HomeModel> implements HomeFragmentContract.HomePresenter{

    @Override
    public void HomePresenter() {
        iModel.HomeModel(Urlconstant.getHomeUrl, new ImpCallBack<HomeFragmentBean>() {
            @Override
            public void onSuccess(HomeFragmentBean bean) {
                iView.onSuccess(bean);
            }

            @Override
            public void onFail(String error) {
                iView.onFail(error);
            }
        });
    }
        @Override
    protected HomeFragmentContract.HomeModel getiModel() {
        return new ImpHomeModel(this);
    }

}
