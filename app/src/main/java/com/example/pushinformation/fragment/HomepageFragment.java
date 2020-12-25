package com.example.pushinformation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pushinformation.R;
import com.example.pushinformation.adapter.HomeFragmentAdapter;
import com.example.pushinformation.base.BaseFragment;
import com.example.pushinformation.base.BasePresenter;
import com.example.pushinformation.bean.HomeFragmentBean;
import com.example.pushinformation.contract.HomeFragmentContract;
import com.example.pushinformation.presenter.ImpHomePresenter;

import java.util.ArrayList;

public class HomepageFragment extends BaseFragment<ImpHomePresenter> implements HomeFragmentContract.HomeView {

    private RecyclerView rcy_home;
    private ArrayList<HomeFragmentBean.DataDTO> list;
    private HomeFragmentAdapter homeFragmentAdapter;
    private DelegateAdapter adapter;

    protected void initView(View view) {
        rcy_home = view.findViewById(R.id.rcy_home);
        list = new ArrayList<>();

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy_home.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,20);

        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        homeFragmentAdapter = new HomeFragmentAdapter(getContext(), singleLayoutHelper);

        adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(homeFragmentAdapter);
        rcy_home.setLayoutManager(virtualLayoutManager);
        rcy_home.setAdapter(adapter);
    }

    @Override
    protected void initDate() {
        presenter.HomePresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected ImpHomePresenter getPresenter() {
        return new ImpHomePresenter();
    }

    @Override
    public void onSuccess(HomeFragmentBean bean) {

    }

    @Override
    public void onFail(String error) {

    }
}