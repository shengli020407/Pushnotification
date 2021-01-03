package com.example.pushinformation.model;

import com.example.pushinformation.contract.FileFragmentContract;
import com.example.pushinformation.retrofitutils.net.FileUtils;
import com.example.pushinformation.retrofitutils.net.ImpCallBack;
import com.example.pushinformation.retrofitutils.net.Utils;

public class ImpFileModel implements FileFragmentContract.FileModel {

    private FileFragmentContract.FilePresenter presenter;

    public ImpFileModel(FileFragmentContract.FilePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void FileModel(String url, ImpCallBack<T> callBack) {
        FileUtils.getFileUtils().get(url,callBack);
    }
}
