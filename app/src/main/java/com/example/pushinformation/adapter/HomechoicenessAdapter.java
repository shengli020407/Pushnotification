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

public class HomechoicenessAdapter extends DelegateAdapter.Adapter{

    private Context context;
    private ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> list;
    private GridLayoutHelper layoutHelper;

    public HomechoicenessAdapter(Context context, ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> list, GridLayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_choiceness_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomechoicenessAdapter.ViewHolder viewHolder= (HomechoicenessAdapter.ViewHolder) holder;
        viewHolder.tv_title_choiceness.setText(list.get(position).getTitle());
        viewHolder.tv_subtitle_choiceness.setText(list.get(position).getSubtitle());
        viewHolder.tv_title_choiceness.setText(list.get(position).getPrice_info()+"");
        Glide.with(context).load(list.get(position).getScene_pic_url()).into(viewHolder.iv_choiceness);
    }

    @Override
    public int getItemCount() {
        return list.size();
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
