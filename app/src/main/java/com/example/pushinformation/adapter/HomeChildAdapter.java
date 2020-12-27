package com.example.pushinformation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
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

public class HomeChildAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.TopicListDTO>listDTOS;

    public HomeChildAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> listDTOS) {
        this.context = context;
        this.listDTOS = listDTOS;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeChildAdapter.ViewHolder viewHolder= (HomeChildAdapter.ViewHolder) holder;
        viewHolder.tv_title_choiceness.setText(listDTOS.get(position).getTitle());
        viewHolder.tv_subtitle_choiceness.setText(listDTOS.get(position).getSubtitle());
        viewHolder.tv_price_choiceness.setText(listDTOS.get(position).getPrice_info()+"");
        Glide.with(context).load(listDTOS.get(position).getScene_pic_url()).into(viewHolder.iv_choiceness);
    }

    @Override
    public int getItemCount() {
        return listDTOS.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_choiceness;
        private TextView tv_title_choiceness;
        private TextView tv_subtitle_choiceness;
        private TextView tv_price_choiceness;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_choiceness = itemView.findViewById(R.id.iv_choiceness);
            tv_title_choiceness = itemView.findViewById(R.id.tv_title_choiceness);
            tv_subtitle_choiceness = itemView.findViewById(R.id.tv_subtitle_choiceness);
            tv_price_choiceness = itemView.findViewById(R.id.tv_price_choiceness);
        }
    }
}
