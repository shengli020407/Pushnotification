package com.example.ringletter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QueryFriendActivity extends AppCompatActivity implements View.OnClickListener {

    private Button queryFriendBtn;
    private RecyclerView queryFriendRcy;
    private ArrayList<String> list;
    private QueryFriendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_friend);
        initView();
    }

    private void initView() {
        queryFriendBtn = findViewById(R.id.bquery_friend_btn);
        queryFriendRcy = findViewById(R.id.query_friend_rcy);
        list = new ArrayList<>();

        queryFriendRcy.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QueryFriendAdapter(this, list);
        queryFriendRcy.setAdapter(adapter);
        queryFriendBtn.setOnClickListener(this);

        adapter.setOnClickListener(new QueryFriendAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(QueryFriendActivity.this, FriendChatActivity.class);
                intent.putExtra("person",list.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bquery_friend_btn:
                send();
                break;
        }
    }

    private void send() {
        Intent intent = new Intent(QueryFriendActivity.this, AddFriendActivity.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2&&resultCode==3){
            String person = data.getStringExtra("person");
            list.add(person);
            adapter.notifyDataSetChanged();
        }
    }
}