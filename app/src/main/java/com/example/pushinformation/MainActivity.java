package com.example.pushinformation;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linner;
    private ImageView ivShare;
    private TextView tvShareShop;
    private FrameLayout flNest;
    private RadioGroup redioDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        linner = findViewById(R.id.linner);
        ivShare = findViewById(R.id.iv_share);
        tvShareShop = findViewById(R.id.tv_share_shop);
        flNest = findViewById(R.id.fl_nest);
        redioDrawer = findViewById(R.id.redio_drawer);
    }
}