package com.example.pushinformation.presenter;

import com.example.pushinformation.base.BasePresenter;
import com.example.pushinformation.bean.FileFragmentBean;
import com.example.pushinformation.contract.FileFragmentContract;
import com.example.pushinformation.model.ImpFileModel;
import com.example.pushinformation.retrofitutils.net.ImpCallBack;
import com.example.pushinformation.retrofitutils.net.Urlconstant;

public class ImpFilePresenter extends BasePresenter<FileFragmentContract.FileView,FileFragmentContract.FileModel> implements FileFragmentContract.FilePresenter {
    @Override
    protected FileFragmentContract.FileModel getiModel() {
        return new ImpFileModel(this);
    }

    @Override
    public void FilePresenter() {
        iModel.FileModel(Urlconstant.getFileUrl, new ImpCallBack<FileFragmentBean>() {
            @Override
            public void onSuccess(FileFragmentBean fileFragmentBean) {
                iView.onSuccess(fileFragmentBean);
            }

            @Override
            public void onFail(String error) {
                iView.onFail(error);
            }
        });
    }
}
