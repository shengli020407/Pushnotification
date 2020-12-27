package com.example.pushinformation.view;

import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentManager;

import com.example.pushinformation.R;
import com.example.pushinformation.base.BaseActivity;
import com.example.pushinformation.fragment.ClassifyFragment;
import com.example.pushinformation.fragment.FileFragment;
import com.example.pushinformation.fragment.HomepageFragment;
import com.example.pushinformation.fragment.PersonFragment;
import com.example.pushinformation.fragment.ShopingFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rediodrawer;
    private FrameLayout fl_nest;
    private RadioButton redio_home;
    private RadioButton redio_file;
    private RadioButton redio_classify;
    private RadioButton redio_shoping;
    private RadioButton redio_person;
    private HomepageFragment homepageFragment;
    private FileFragment fileFragment;
    private FragmentManager supportFragmentManager;
    private ClassifyFragment classifyFragment;
    private ShopingFragment shopingFragment;
    private PersonFragment personFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    protected void initView() {
        fl_nest = findViewById(R.id.fl_nest);
        rediodrawer = findViewById(R.id.redio_drawer);
        redio_home = findViewById(R.id.redio_home);
        redio_file = findViewById(R.id.redio_file);
        redio_classify = findViewById(R.id.redio_classify);
        redio_shoping = findViewById(R.id.redio_shoping);
        redio_person = findViewById(R.id.redio_person);

        rediodrawer.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initDate() {
        homepageFragment = new HomepageFragment();
        fileFragment = new FileFragment();
        classifyFragment = new ClassifyFragment();
        shopingFragment = new ShopingFragment();
        personFragment = new PersonFragment();
        redio_home.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.redio_home:
                supportFragmentManager = getSupportFragmentManager();
                if (supportFragmentManager.getFragments().size() == 0) {
                    supportFragmentManager.beginTransaction().add(R.id.fl_nest, homepageFragment)
                            .commit();
                } else {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_nest, homepageFragment)
                            .commit();
                }
                break;
            case R.id.redio_file:
                supportFragmentManager.beginTransaction().replace(R.id.fl_nest, fileFragment)
                        .commit();
                break;
            case R.id.redio_classify:
                supportFragmentManager.beginTransaction().replace(R.id.fl_nest, classifyFragment)
                        .commit();
                break;
            case R.id.redio_shoping:
                supportFragmentManager.beginTransaction().replace(R.id.fl_nest, shopingFragment)
                        .commit();
                break;
            case R.id.redio_person:
                supportFragmentManager.beginTransaction().replace(R.id.fl_nest, personFragment)
                        .commit();
                break;
        }
    }
}