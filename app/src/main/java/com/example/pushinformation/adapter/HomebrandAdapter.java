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

public class HomebrandAdapter extends DelegateAdapter.Adapter{
    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.BrandListDTO> list;
    private GridLayoutHelper layoutHelper;

    public HomebrandAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.BrandListDTO> list, GridLayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_brand_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomebrandAdapter.ViewHolder viewHolder= (HomebrandAdapter.ViewHolder) holder;
        viewHolder.tv_name_brand.setText(list.get(position).getName());
        viewHolder.tv_price_brand.setText(list.get(position).getFloor_price());
        Glide.with(context).load(list.get(position).getNew_pic_url()).into(viewHolder.iv_brand);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_brand;
        private TextView tv_name_brand;
        private TextView tv_price_brand;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_brand = itemView.findViewById(R.id.iv_brand);
            tv_name_brand = itemView.findViewById(R.id.tv_name_brand);
            tv_price_brand = itemView.findViewById(R.id.tv_price_brand);
        }
    }
}
