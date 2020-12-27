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

public class HomeGridAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.ChannelDTO>list;
    private GridLayoutHelper layoutHelper;

    public HomeGridAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.ChannelDTO> list, GridLayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeGridAdapter.ViewHolder viewHolder = (HomeGridAdapter.ViewHolder) holder;
        viewHolder.tvNameGrid.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon_url()).into(viewHolder.ivGrid);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivGrid;
        private TextView tvNameGrid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
            tvNameGrid = itemView.findViewById(R.id.tv_name_grid);
        }
    }

}
