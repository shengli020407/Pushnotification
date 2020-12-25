package com.example.pushinformation.base;

public abstract class BasePresenter<V extends BaseView , M extends BaseModel> {

    public V iView;
    public M iModel;

    public void attchview(V v){
        iView=v;
        iModel=getiModel();
    }

    protected abstract M getiModel();

}
