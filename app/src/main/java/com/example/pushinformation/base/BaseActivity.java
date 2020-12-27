package com.example.pushinformation.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pushinformation.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        Log.e("TAG", "onCreate: " + getLayout());
        Log.e("TAG", "onCreate: " + R.layout.activity_main);
        initView();
        initDate();
    }

    protected abstract void initView();

    protected abstract void initDate();

    protected abstract int getLayout();

}
