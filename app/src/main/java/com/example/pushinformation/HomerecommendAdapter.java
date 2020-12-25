package com.example.pushinformation;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.pushinformation.bean.HomeFragmentBean;

import java.util.ArrayList;

public class HomerecommendAdapter extends DelegateAdapter.Adapter{

    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.NewGoodsListDTO> list;
    private GridLayoutHelper layoutHelper;

    public HomerecommendAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.NewGoodsListDTO> list, GridLayoutHelper layoutHelper) {
        this.context = context;
        this.list = list;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
