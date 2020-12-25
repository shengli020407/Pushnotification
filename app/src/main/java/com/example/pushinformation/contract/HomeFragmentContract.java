package com.example.pushinformation.contract;

import com.example.pushinformation.base.BaseModel;
import com.example.pushinformation.base.BaseView;
import com.example.pushinformation.bean.HomeFragmentBean;
import com.example.pushinformation.retrofitutils.net.ImpCallBack;

public class HomeFragmentContract {

    public interface HomeView extends BaseView {
        void onSuccess(HomeFragmentBean bean);
        void onFail(String error);
    }

    public interface HomeModel extends BaseModel {
        <T> void HomeModel(String url, ImpCallBack<T> callBack);
    }

    public interface HomePresenter extends BaseView{
        void HomePresenter();
    }

}
