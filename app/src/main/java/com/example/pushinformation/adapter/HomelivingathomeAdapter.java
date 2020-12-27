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

public class HomelivingathomeAdapter extends DelegateAdapter.Adapter{

    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO> list;
    private GridLayoutHelper layoutHelper;

    public HomelivingathomeAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO> list, GridLayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_livingathome_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomelivingathomeAdapter.ViewHolder viewHolder= (HomelivingathomeAdapter.ViewHolder) holder;
        viewHolder.tv_name_livingathome.setText(list.get(position).getGoodsList().get(position).getName());
        viewHolder.tv_price_livingathome.setText(list.get(position).getGoodsList().get(position).getRetail_price()+"");
        Glide.with(context).load(list.get(position).getGoodsList().get(position).getList_pic_url()).into(viewHolder.iv_livingathome);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_livingathome;
        private TextView tv_name_livingathome;
        private TextView tv_price_livingathome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_livingathome = itemView.findViewById(R.id.iv_livingathome);
            tv_name_livingathome = itemView.findViewById(R.id.tv_name_livingathome);
            tv_price_livingathome = itemView.findViewById(R.id.tv_price_livingathome);
        }
    }
}
