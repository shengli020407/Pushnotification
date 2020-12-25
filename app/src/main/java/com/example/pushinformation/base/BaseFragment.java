package com.example.pushinformation.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.pushinformation.R;

public abstract class BaseFragment <T extends BasePresenter> extends Fragment implements BaseView {

    public T presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        if (presenter==null){
            presenter=getPresenter();
            presenter.attchview(this);
        }

        initView(view);
        initDate();
        return view;
    }

    protected abstract void initView(View view);

    protected abstract void initDate();

    protected abstract int getLayout();

    protected abstract T getPresenter();
}
