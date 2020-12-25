package com.example.pushinformation.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pushinformation.R;
import com.example.pushinformation.adapter.HomeFragmentAdapter;
import com.example.pushinformation.adapter.HomeGridAdapter;
import com.example.pushinformation.adapter.HomebrandAdapter;
import com.example.pushinformation.adapter.HomefirstpublishAdapter;
import com.example.pushinformation.base.BaseFragment;
import com.example.pushinformation.base.BasePresenter;
import com.example.pushinformation.bean.HomeFragmentBean;
import com.example.pushinformation.contract.HomeFragmentContract;
import com.example.pushinformation.presenter.ImpHomePresenter;

import java.util.ArrayList;

public class HomepageFragment extends BaseFragment<ImpHomePresenter> implements HomeFragmentContract.HomeView {

    private RecyclerView rcy_home;
    private ArrayList<HomeFragmentBean.DataDTO.BannerDTO> bannerDTOS;
    private HomeFragmentAdapter homeFragmentAdapter;
    private ArrayList<HomeFragmentBean.DataDTO.ChannelDTO> channelDTOS;
    private HomeGridAdapter homeGridAdapter;
    private DelegateAdapter adapter;
    private ArrayList<HomeFragmentBean.DataDTO.BrandListDTO> brandListDTOS;
    private HomebrandAdapter homebrandAdapter;
    private ArrayList<HomeFragmentBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private HomefirstpublishAdapter homefirstpublishAdapter;

    protected void initView(View view) {
        rcy_home = view.findViewById(R.id.rcy_home);
        bannerDTOS = new ArrayList<>();
        channelDTOS = new ArrayList<>();
        brandListDTOS = new ArrayList<>();
        newGoodsListDTOS = new ArrayList<>();
        //轮播图
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy_home.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 50);
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        //轮播图下边的
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setItemCount(5);
        gridLayoutHelper.setPadding(10,10,10,10);
        gridLayoutHelper.setMargin(10,10,10,10);
        gridLayoutHelper.setAspectRatio(5);
        gridLayoutHelper.setWeights(new float[]{20,20,20,20});
        gridLayoutHelper.setVGap(20);
        gridLayoutHelper.setHGap(20);
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setSpanCount(5);
        //品牌制造商直供
        GridLayoutHelper helper = new GridLayoutHelper(4);
        helper.setItemCount(4);
        helper.setMargin(30,0,30,30);
        helper.setSpanCount(2);
        //周一周四新品首发
        GridLayoutHelper firstpublishgridLayoutHelper = new GridLayoutHelper(4);
        firstpublishgridLayoutHelper.setItemCount(4);
        firstpublishgridLayoutHelper.setMargin(30,0,30,30);
        firstpublishgridLayoutHelper.setSpanCount(2);

        homeFragmentAdapter = new HomeFragmentAdapter(getContext(), singleLayoutHelper, bannerDTOS);
        homeGridAdapter = new HomeGridAdapter(getContext(), channelDTOS, gridLayoutHelper);
        homebrandAdapter = new HomebrandAdapter(getContext(), brandListDTOS, helper);
        homefirstpublishAdapter = new HomefirstpublishAdapter(getContext(), newGoodsListDTOS, firstpublishgridLayoutHelper);
        adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(homeFragmentAdapter);
        adapter.addAdapter(homeGridAdapter);
        adapter.addAdapter(homebrandAdapter);
        adapter.addAdapter(homefirstpublishAdapter);
        rcy_home.setLayoutManager(virtualLayoutManager);
        rcy_home.setAdapter(adapter);
        //人气推荐
        GridLayoutHelper recommendhelper = new GridLayoutHelper(3);
        recommendhelper.setItemCount(4);
        recommendhelper.setMargin(10,0,10,10);
        recommendhelper.setSpanCount(1);
    }

    @Override
    protected ImpHomePresenter getPresenter() {
        return new ImpHomePresenter();
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
    public void onSuccess(HomeFragmentBean bean) {
        bannerDTOS.addAll(bean.getData().getBanner());
        channelDTOS.addAll(bean.getData().getChannel());
        brandListDTOS.addAll(bean.getData().getBrandList());
        newGoodsListDTOS.addAll(bean.getData().getNewGoodsList());
        homeFragmentAdapter.notifyDataSetChanged();
        homeGridAdapter.notifyDataSetChanged();
        homebrandAdapter.notifyDataSetChanged();
        homefirstpublishAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}