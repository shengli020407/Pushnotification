package com.example.pushinformation.retrofitutils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class FileUtils implements ImpNetWorkInterFace{

    private static FileUtils fileUtils;
    private final ApiService apiService;

    public FileUtils() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Urlconstant.FileUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = build.create(ApiService.class);
    }

    public static FileUtils getFileUtils() {
        if (fileUtils==null){
            synchronized (FileUtils.class){
                if (fileUtils==null){
                    fileUtils=new FileUtils();
                }
            }
        }
        return fileUtils;
    }

    @Override
    public <T> void get(String url, ImpCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] typeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type typeArgument = typeArguments[0];
                            T json = new Gson().fromJson(string, typeArgument);
                            callBack.onSuccess(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail("网络异常"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
