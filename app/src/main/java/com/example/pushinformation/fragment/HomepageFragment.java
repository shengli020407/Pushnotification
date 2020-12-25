package com.example.pushinformation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.pushinformation.R;

public class HomepageFragment extends Fragment {

    private RecyclerView rcy_home;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rcy_home = view.findViewById(R.id.rcy_home);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        rcy_home.setLayoutManager(virtualLayoutManager);

        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy_home.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,20);

    }
}