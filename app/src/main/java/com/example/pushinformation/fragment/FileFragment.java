package com.example.pushinformation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pushinformation.R;
import com.example.pushinformation.adapter.FileShoeAdapter;
import com.example.pushinformation.base.BaseFragment;
import com.example.pushinformation.bean.FileFragmentBean;
import com.example.pushinformation.contract.FileFragmentContract;
import com.example.pushinformation.presenter.ImpFilePresenter;
import com.example.pushinformation.presenter.ImpHomePresenter;

import java.util.ArrayList;

public class FileFragment extends BaseFragment<ImpFilePresenter> implements FileFragmentContract.FileView {

    private RecyclerView rcy_file;
    private DelegateAdapter adapter;
    private ArrayList<FileFragmentBean.DataDTO.DataDTO1> list;
    private FileShoeAdapter fileShoeAdapter;


    protected void initView(View view) {
        rcy_file = view.findViewById(R.id.rcy_file);
        //VLayout
        initVLayout();
        //关爱他成长的每一个足迹
        initShoe();
    }

    @Override
    protected void initDate() {
        presenter.FilePresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_file;
    }

    @Override
    protected ImpFilePresenter getPresenter() {
        return new ImpFilePresenter();
    }

    private void initShoe() {
        SingleLayoutHelper shoeLayoutHelper = new SingleLayoutHelper();
        shoeLayoutHelper.setItemCount(1);
        list = new ArrayList<>();
        fileShoeAdapter = new FileShoeAdapter(getContext(), shoeLayoutHelper, list);
        adapter.addAdapter(fileShoeAdapter);
    }

    private void initVLayout() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy_file.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 100);
        adapter = new DelegateAdapter(layoutManager, false);
        rcy_file.setLayoutManager(layoutManager);
        rcy_file.setAdapter(adapter);
    }

    @Override
    public void onSuccess(FileFragmentBean bean) {
        list.addAll(bean.getData().getData());
        fileShoeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
//        Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
    }
}