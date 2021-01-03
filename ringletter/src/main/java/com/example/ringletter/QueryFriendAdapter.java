package com.example.ringletter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QueryFriendAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<String>list;
    private OnClickListener onClickListener;
    public QueryFriendAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.query_friend_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        viewHolder.query_friend_tv.setText(list.get(position));

        viewHolder.query_friend_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView query_friend_tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            query_friend_tv = itemView.findViewById(R.id.query_friend_tv);
        }
    }
    public interface OnClickListener{
        void onClick(int position);
    }
}
