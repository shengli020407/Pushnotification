package com.example.pushinformation;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pushinformation.fragment.ClassifyFragment;
import com.example.pushinformation.fragment.FileFragment;
import com.example.pushinformation.fragment.HomepageFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private LinearLayout linner;
    private ImageView ivShare;
    private TextView tvShareShop;
    private FrameLayout flNest;
    private RadioGroup redioDrawer;
    private ArrayList<Fragment> list;
    private RadioButton redioHome;
    private RadioButton redioFile;
    private RadioButton redioClassify;
    private RadioButton redioShoping;
    private RadioButton redioPerson;
    private FragmentTransaction fragmentTransaction;
    private HomepageFragment homepageFragment;
    private FileFragment fileFragment;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
        initListener();
    }

    private void initListener() {
        redioDrawer.setOnCheckedChangeListener(this::onCheckedChanged);
        redioDrawer.check(R.id.redio_home);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.redio_home:
                position =0;
                break;
            case R.id.redio_file:
                position =1;
                break;
            case R.id.redio_classify:
                position =2;
                break;
            case R.id.redio_shoping:
                position =3;
                break;
            case R.id.redio_person:
                position =4;
                break;
        }
    }


    private void initDate() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        homepageFragment = new HomepageFragment();
        fileFragment = new FileFragment();
        fragmentTransaction.add(R.id.fl_nest,homepageFragment)
                .show(homepageFragment)
                .hide(fileFragment)
                .commit();

    }


    private void initView() {
        linner = findViewById(R.id.linner);
        ivShare = findViewById(R.id.iv_share);
        tvShareShop = findViewById(R.id.tv_share_shop);
        flNest = findViewById(R.id.fl_nest);
        redioDrawer = findViewById(R.id.redio_drawer);
        redioHome = findViewById(R.id.redio_home);
        redioFile = findViewById(R.id.redio_file);
        redioClassify = findViewById(R.id.redio_classify);
        redioShoping = findViewById(R.id.redio_shoping);
        redioPerson = findViewById(R.id.redio_person);

        list = new ArrayList<>();
        list.add(new HomepageFragment());
        list.add(new FileFragment());
        list.add(new ClassifyFragment());
    }



}