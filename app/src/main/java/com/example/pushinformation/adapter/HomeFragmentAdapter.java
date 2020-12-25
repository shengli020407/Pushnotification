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
    private ArrayList<String> list;

    public HomeFragmentAdapter(Context context, SingleLayoutHelper layoutHelper) {
        this.context = context;
        this.layoutHelper = layoutHelper;
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
        list = new ArrayList<>();
        list.add("http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg");
        list.add("http://yanxuan.nosdn.127.net/bff2e49136fcef1fd829f5036e07f116.jpg");
        list.add("http://yanxuan.nosdn.127.net/8e50c65fda145e6dd1bf4fb7ee0fcecc.jpg");
        viewHolder.ban_home.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeFragmentBean.DataDTO dataDTO= (HomeFragmentBean.DataDTO) path;
                        Glide.with(context).load(dataDTO.getBanner()).into(imageView);
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
