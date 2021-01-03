package com.example.ringletter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendChatActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView friendChatName;
    private RecyclerView friendChatRcy;
    private EditText friendChatInput;
    private ImageView friend_chat_image;
    private Button friendChatSend;
    private ArrayList<String> list;
    private FriendChatAdapter adapter;
    private ImageView chat_popu_album;
    private TextView chat_popu_album_name;
    private WindowManager.LayoutParams attributes;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_chat);
        initView();
        initDate();
    }

    private void initDate() {
        adapter.setOnLongClickListener(new FriendChatAdapter.OnLongClickListener() {
            @Override
            public void onLongClick(int position) {
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        friendChatName = findViewById(R.id.friend_chat_name);
        friendChatRcy = findViewById(R.id.friend_chat_rcy);
        friend_chat_image = findViewById(R.id.friend_chat_image);
        friendChatInput = findViewById(R.id.friend_chat_input);
        friendChatSend = findViewById(R.id.friend_chat_send);
        list = new ArrayList<>();
        friendChatRcy.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FriendChatAdapter(this, list);
        friendChatRcy.setAdapter(adapter);

        String person = getIntent().getStringExtra("person");
        friendChatName.setText(person);

        friendChatSend.setOnClickListener(this);
        friend_chat_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.friend_chat_send:
                send();
                break;
            case R.id.friend_chat_image:
                popu();
                break;
        }
    }

    private void popu() {
        View view = LayoutInflater.from(this).inflate(R.layout.chat_poou_item, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM,0,0);
        chat_popu_album = view.findViewById(R.id.chat_popu_album);
        chat_popu_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });
        attributes = getWindow().getAttributes();
        attributes.alpha=0.4f;
        getWindow().setAttributes(attributes);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                attributes.alpha=1;
                getWindow().setAttributes(attributes);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void send() {
        String input = friendChatInput.getText().toString();
        if (TextUtils.isEmpty(input)){
            Toast.makeText(this, "不能发送空消息", Toast.LENGTH_SHORT).show();
        }
        list.add(input);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==RESULT_OK){
            Uri uri = data.getData();
            list.add(String.valueOf(uri));
            popupWindow.dismiss();
            adapter.notifyDataSetChanged();
        }
    }
}