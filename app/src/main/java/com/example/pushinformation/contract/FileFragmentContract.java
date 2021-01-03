package com.example.pushinformation.contract;

import com.example.pushinformation.base.BaseModel;
import com.example.pushinformation.base.BaseView;
import com.example.pushinformation.bean.FileFragmentBean;
import com.example.pushinformation.retrofitutils.net.ImpCallBack;

public class FileFragmentContract {

    public interface FileView extends BaseView {
        void onSuccess(FileFragmentBean bean);
        void onFail(String error);
    }

    public interface FileModel extends BaseModel {
        <T> void FileModel(String url, ImpCallBack<T> callBack);
    }

    public interface FilePresenter extends BaseView{
        void FilePresenter();
    }
}
