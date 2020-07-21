package com.example.study.ui;

import android.app.Application;

import com.example.study.http.HttpUtils;

public class BaseApplication extends Application {

    private static Application appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        HttpUtils.getInstance().init(this);
    }

    public static Application getAppContext() {
        return appContext;
    }

}