package com.example.pushinformation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pushinformation.R;
import com.example.pushinformation.bean.HomeFragmentBean;

import java.util.ArrayList;

public class ToppAdapter extends RecyclerView.Adapter<ToppAdapter.Holder> {
    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> toplist;

    public ToppAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> toplist) {
        this.context = context;
        this.toplist = toplist;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.topp_item,null);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ToppAdapter.Holder v=holder;
        HomeFragmentBean.DataDTO.TopicListDTO dto = toplist.get(position);
        Glide.with(context).load(dto.getItem_pic_url()).into(holder.img);
        v.tv.setText(dto.getTitle()+"");
        v.tv1.setText(dto.getSubtitle()+"");
    }

    @Override
    public int getItemCount() {
        return toplist.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        private TextView tv1;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv=itemView.findViewById(R.id.tv1);
            tv1=itemView.findViewById(R.id.tv2);
        }
    }
}
