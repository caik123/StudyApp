package com.example.study;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {
    private View view;
    private boolean isFirstLoad = true;

    public Fragment4() {
        // Required empty public constructor
    }

    public static Fragment4 newInstance(String param1, String param2) {
        Fragment4 fragment = new Fragment4();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("test", "onCreate4");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("test", "onCreateView4");
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_4, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("test", "onViewCreated4");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        //懒加载
        if (isFirstLoad) {
            isFirstLoad = false;
            Log.e("test", "第4个Fragment懒加载");
            //lazyLoad();
        }
    }
}
