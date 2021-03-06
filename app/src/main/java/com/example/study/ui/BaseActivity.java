package com.example.study.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.study.R;
import com.xingtu.globalnetworkchange.NetworkManager;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        NetworkManager.getDefault().init(getApplication());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
