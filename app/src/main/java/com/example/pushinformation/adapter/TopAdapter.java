package com.example.pushinformation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pushinformation.R;
import com.example.pushinformation.bean.HomeFragmentBean;

import java.util.ArrayList;

public class TopAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> toplist;

    public TopAdapter(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<HomeFragmentBean.DataDTO.TopicListDTO> toplist) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.toplist = toplist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= View.inflate(context, R.layout.top_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TopAdapter.Holder viewHolder= (Holder) holder;
        RecyclerView rlv1=viewHolder.rlv;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rlv1.setLayoutManager(linearLayoutManager);
        ToppAdapter toppAdapter = new ToppAdapter(context,toplist);
        rlv1.setAdapter(toppAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class Holder extends RecyclerView.ViewHolder {
        private RecyclerView rlv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            rlv=itemView.findViewById(R.id.rlv);
        }
    }
}
