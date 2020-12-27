package com.example.pushinformation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pushinformation.R;

public class HomeNewproductAdapter extends DelegateAdapter.Adapter{
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public HomeNewproductAdapter(Context context, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_directsupply_home, parent, false);
        return new HomeNewproductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeNewproductAdapter.ViewHolder viewHolder= (HomeNewproductAdapter.ViewHolder) holder;
        viewHolder.tv_directsupply.setText("周一周四·新品首发");
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_directsupply;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_directsupply = itemView.findViewById(R.id.tv_directsupply);
        }
    }
}
