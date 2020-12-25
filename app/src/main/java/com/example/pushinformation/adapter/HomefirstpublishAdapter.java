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

public class HomefirstpublishAdapter extends DelegateAdapter.Adapter{

    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.NewGoodsListDTO> list;
    private GridLayoutHelper layoutHelper;

    public HomefirstpublishAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.NewGoodsListDTO> list, GridLayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_firstpublish_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomefirstpublishAdapter.ViewHolder viewHolder= (HomefirstpublishAdapter.ViewHolder) holder;
        viewHolder.tv_name_firstpublish.setText(list.get(position).getName());
        viewHolder.tv_price_firstpublish.setText(list.get(position).getRetail_price());
        Glide.with(context).load(list.get(position).getList_pic_url()).into(viewHolder.iv_firstpublish);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_firstpublish;
        private TextView tv_name_firstpublish;
        private TextView tv_price_firstpublish;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_firstpublish = itemView.findViewById(R.id.iv_firstpublish);
            tv_name_firstpublish = itemView.findViewById(R.id.tv_name_firstpublish);
            tv_price_firstpublish = itemView.findViewById(R.id.tv_price_firstpublish);
        }
    }
}
