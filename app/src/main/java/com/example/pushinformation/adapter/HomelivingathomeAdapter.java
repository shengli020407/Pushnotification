package com.example.pushinformation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.pushinformation.R;
import com.example.pushinformation.bean.HomeFragmentBean;

import java.util.ArrayList;
import java.util.List;

public class HomelivingathomeAdapter extends DelegateAdapter.Adapter{

    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO> list;
    private SingleLayoutHelper layoutHelper;

    public HomelivingathomeAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO> list, SingleLayoutHelper layoutHelper) {
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
        ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = (ArrayList<HomeFragmentBean.DataDTO.CategoryListDTO.GoodsListDTO>) list.get(position).getGoodsList();

        HomelivingathomeAdapter.ViewHolder viewHolder= (HomelivingathomeAdapter.ViewHolder) holder;
        viewHolder.tv_title.setText(list.get(position).getName());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        HomelivingathomeChildAdapter homelivingathomeChildAdapter = new HomelivingathomeChildAdapter(context,goodsList);
        viewHolder.rec.setLayoutManager(gridLayoutManager);
        viewHolder.rec.setAdapter(homelivingathomeChildAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private RecyclerView rec;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            rec = itemView.findViewById(R.id.rec);
        }
    }
}
