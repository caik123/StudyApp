package com.example.study.test;

import android.util.Log;

public class Car implements ICar {
    @Override
    public void run() {
        Log.e("test","car run");
    }
}
