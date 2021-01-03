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
import com.example.pushinformation.bean.FileFragmentBean;

import java.util.ArrayList;

public class FileShoeAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<FileFragmentBean.DataDTO.DataDTO1>list;

    public FileShoeAdapter(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<FileFragmentBean.DataDTO.DataDTO1> list) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shoe_file, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FileShoeAdapter.ViewHolder viewHolder= (FileShoeAdapter.ViewHolder) holder;
        Glide.with(context).load(list.get(position).getScene_pic_url()).into(viewHolder.iv_shoe);
        viewHolder.tv_name_shoe.setText(list.get(position).getTitle());
        viewHolder.tv_subtitle_shoe.setText(list.get(position).getSubtitle());
        viewHolder.tv_price_shoe.setText(list.get(position).getPrice_info()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_shoe;
        private TextView tv_name_shoe;
        private TextView tv_subtitle_shoe;
        private TextView tv_price_shoe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_shoe = itemView.findViewById(R.id.iv_shoe);
            tv_name_shoe = itemView.findViewById(R.id.tv_name_shoe);
            tv_subtitle_shoe = itemView.findViewById(R.id.tv_subtitle_shoe);
            tv_price_shoe = itemView.findViewById(R.id.tv_price_shoe);
        }
    }

}
