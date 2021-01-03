package com.example.ringletter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendChatAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String>list;

    public FriendChatAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friend_chat_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        viewHolder.friend_chat_iv.setImageResource(R.mipmap.ic_launcher);
        viewHolder.friend_chat_tv_input.setText(list.get(position));
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClickListener.onLongClick(position);
                return false;
            }
        });
    }
    private OnLongClickListener onLongClickListener;
    public interface OnLongClickListener {
        void onLongClick(int position);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView friend_chat_tv_input;
        private ImageView friend_chat_iv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             friend_chat_tv_input = itemView.findViewById(R.id.friend_chat_tv_input);
            friend_chat_iv = itemView.findViewById(R.id.friend_chat_iv);
        }
    }

}
