package com.example.pushinformation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.pushinformation.R;
import com.example.pushinformation.bean.HomeFragmentBean;

import java.util.ArrayList;

public class HomekitchenwareAdapter extends DelegateAdapter.Adapter{


    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO> list;
    private GridLayoutHelper layoutHelper;

    public HomekitchenwareAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO> list, GridLayoutHelper layoutHelper) {
        this.context = context;
        this.list = list;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kitchenware_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomekitchenwareAdapter.ViewHolder viewHolder= (HomekitchenwareAdapter.ViewHolder) holder;
        viewHolder.tv_name_kitchenware.setText(list.get(position).getGoodsList().get(position).getName());
        viewHolder.tv_price_kitchenware.setText(list.get(position).getGoodsList().get(position).getRetail_price()+"");
        Glide.with(context).load(list.get(position).getGoodsList().get(position).getList_pic_url()).into(viewHolder.iv_kitchenware);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_kitchenware;
        private TextView tv_name_kitchenware;
        private TextView tv_price_kitchenware;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_kitchenware = itemView.findViewById(R.id.iv_kitchenware);
            tv_name_kitchenware = itemView.findViewById(R.id.tv_name_kitchenware);
            tv_price_kitchenware = itemView.findViewById(R.id.tv_price_kitchenware);
        }
    }
}
