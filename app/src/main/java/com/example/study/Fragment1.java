package com.example.study;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.study.camera.CameraActivity;
import com.example.study.tree.TreeActivity;
import com.example.study.utils.ThreadManager;


/**
 * 结论：从源码中得到的结论是，Fragment数据的初始化应当在onResume方法中执行，可实现懒加载。
 */
public class Fragment1 extends Fragment {
    private static final String TAG = Fragment1.class.getSimpleName();
    private View view;
    private boolean isFirstLoad = true;

    public Fragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("test", "onCreate1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("test", "onCreateView1");
        // Inflate the layout for this fragment
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_1, container, false);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TreeActivity.class));
            }
        });
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CameraActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        //懒加载
        if (isFirstLoad) {
            isFirstLoad = false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止加载
        //stopLoad();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
