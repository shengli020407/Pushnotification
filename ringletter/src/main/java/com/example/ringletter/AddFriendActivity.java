package com.example.ringletter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddFriendActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_friend_insert;
    private EditText friend_insert_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        initView();
    }

    private void initView() {
        btn_friend_insert = findViewById(R.id.btn_friend_insert);
        friend_insert_et = findViewById(R.id.friend_insert_et);

        btn_friend_insert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_friend_insert:
                insert();
                break;
        }
    }

    private void insert() {
        String person = friend_insert_et.getText().toString();

        Intent intent = new Intent(this,QueryFriendActivity.class);
        intent.putExtra("person",person);
        setResult(3,intent);
        finish();
    }
}