package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.study.net.NetChangeObserver;
import com.example.study.net.NetworkManager;

public class BaseActivity extends AppCompatActivity implements NetChangeObserver {
    private static final String TAG = BaseActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        NetworkManager.getDefault().init(getApplication());
        NetworkManager.getDefault().setListener(this);
    }

    @Override
    public void onConnected(String type) {
        Log.i(TAG,"网络连上了---type="+type);
    }

    @Override
    public void onDisConnected() {
        Log.i(TAG,"网络断开了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetworkManager.getDefault().logout();
    }
}
