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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.pushinformation.R;
import com.example.pushinformation.bean.HomeFragmentBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeFragmentAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper layoutHelper;
    private ArrayList<HomeFragmentBean.DataDTO.BannerDTO> list;

    public HomeFragmentAdapter(Context context, SingleLayoutHelper layoutHelper, ArrayList<HomeFragmentBean.DataDTO.BannerDTO> list) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_ban, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeFragmentAdapter.ViewHolder viewHolder= (HomeFragmentAdapter.ViewHolder) holder;
        viewHolder.ban_home.setImages(list).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeFragmentBean.DataDTO.BannerDTO dataDTO= (HomeFragmentBean.DataDTO.BannerDTO) path;
                        Glide.with(context).load(dataDTO.getImage_url()).into(imageView);
                    }
                }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private Banner ban_home;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ban_home = itemView.findViewById(R.id.ban_home);
        }
    }

}
