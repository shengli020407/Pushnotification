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
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pushinformation.HomerecommendAdapter;
import com.example.pushinformation.R;
import com.example.pushinformation.adapter.HomeFragmentAdapter;
import com.example.pushinformation.adapter.HomeGridAdapter;
import com.example.pushinformation.adapter.HomeGridAdapter;
import com.example.pushinformation.adapter.HomebrandAdapter;
import com.example.pushinformation.adapter.HomechoicenessAdapter;
import com.example.pushinformation.adapter.HomefirstpublishAdapter;
import com.example.pushinformation.adapter.HomekitchenwareAdapter;
import com.example.pushinformation.adapter.HomelivingathomeAdapter;
import com.example.pushinformation.adapter.TopAdapter;
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
    private ArrayList<HomeFragmentBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private HomerecommendAdapter homerecommendAdapter;
    private ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> topicListDTOS;
    private  HomechoicenessAdapter homechoicenessAdapter;
    private ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO> categoryListDTOS;
    private HomelivingathomeAdapter homelivingathomeAdapter;

    protected void initView(View view) {
        rcy_home = view.findViewById(R.id.rcy_home);
        //VLayout
        initVlayout();
        //轮播图
        initBanner();
        //轮播图下边
        initInferior();
        //品牌制造商直供
        initBrand();
        //周一周四新品首发
        initFirstpublishgrid();
        //人气推荐
        initRecommendhelper();
        //专题精选
        initSinhelper();
        //居家
        initLivingathome();
    }

    private void initVlayout() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy_home.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 100);
        adapter = new DelegateAdapter(virtualLayoutManager, false);
        rcy_home.setLayoutManager(virtualLayoutManager);
        rcy_home.setAdapter(adapter);
    }

    private void initLivingathome() {
        //居家
        categoryListDTOS = new ArrayList<>();
        SingleLayoutHelper livingathome = new SingleLayoutHelper();
        livingathome.setItemCount(2);
        homelivingathomeAdapter = new HomelivingathomeAdapter(getContext(), categoryListDTOS, livingathome);
        adapter.addAdapter(homelivingathomeAdapter);
    }

    private void initSinhelper() {
        //专题精选
        topicListDTOS = new ArrayList<>();
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        homechoicenessAdapter = new HomechoicenessAdapter(getContext(),topicListDTOS,singleLayoutHelper);
        adapter.addAdapter(homechoicenessAdapter);
    }

    private void initRecommendhelper() {
        //人气推荐
        hotGoodsListDTOS = new ArrayList<>();
        GridLayoutHelper recommendhelper = new GridLayoutHelper(4);
        recommendhelper.setItemCount(4);
        recommendhelper.setSpanCount(1);
        homerecommendAdapter = new HomerecommendAdapter(getContext(), hotGoodsListDTOS, recommendhelper);
        adapter.addAdapter(homerecommendAdapter);
    }

    private void initFirstpublishgrid() {
        //周一周四新品首发
        newGoodsListDTOS = new ArrayList<>();
        GridLayoutHelper firstpublishgridLayoutHelper = new GridLayoutHelper(4);
        firstpublishgridLayoutHelper.setItemCount(4);
        firstpublishgridLayoutHelper.setSpanCount(2);
        homefirstpublishAdapter = new HomefirstpublishAdapter(getContext(), newGoodsListDTOS, firstpublishgridLayoutHelper);
        adapter.addAdapter(homefirstpublishAdapter);
    }

    private void initBrand() {
        //品牌制造商直供
        brandListDTOS = new ArrayList<>();
        GridLayoutHelper helper = new GridLayoutHelper(4);
        helper.setItemCount(4);
        helper.setPadding(0,0,0,0);
        helper.setMargin(0,0,0,0);
        helper.setSpanCount(2);
        homebrandAdapter = new HomebrandAdapter(getContext(), brandListDTOS, helper);
        adapter.addAdapter(homebrandAdapter);
    }

    private void initInferior() {
        //轮播图下边的
        channelDTOS = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setItemCount(5);
        gridLayoutHelper.setPadding(10,10,10,10);
        gridLayoutHelper.setMargin(10,10,10,10);
        gridLayoutHelper.setWeights(new float[]{20,20,20,20});
        gridLayoutHelper.setSpanCount(5);
        homeGridAdapter = new HomeGridAdapter(getContext(), channelDTOS, gridLayoutHelper);
        adapter.addAdapter(homeGridAdapter);

    }

    private void initBanner() {
        //轮播图
        bannerDTOS = new ArrayList<>();
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        homeFragmentAdapter = new HomeFragmentAdapter(getContext(), singleLayoutHelper, bannerDTOS);
        adapter.addAdapter(homeFragmentAdapter);
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
        hotGoodsListDTOS.addAll(bean.getData().getHotGoodsList());
        topicListDTOS.addAll(bean.getData().getTopicList());
        categoryListDTOS.addAll(bean.getData().getCategoryList());

        homeFragmentAdapter.notifyDataSetChanged();
        homeGridAdapter.notifyDataSetChanged();
        homebrandAdapter.notifyDataSetChanged();
        homefirstpublishAdapter.notifyDataSetChanged();
        homerecommendAdapter.notifyDataSetChanged();
        homechoicenessAdapter.notifyDataSetChanged();
        homelivingathomeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}