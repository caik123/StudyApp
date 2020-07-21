package com.example.study.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alibaba.fastjson.JSON;
import com.example.study.bean.Weather;
import com.example.study.http.HttpUtils;
import com.example.study.http2.ApiUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;

public class Fragment2ViewModel extends ViewModel {
    private MutableLiveData<Weather> weatherMutableLiveData;

    public Fragment2ViewModel() {
        super();
        weatherMutableLiveData = new MutableLiveData<>();
    }

    public void queryWeather(String cityName) {
        HashMap<String, String> map = new HashMap<>();
        map.put("cityname", cityName);
        ApiUtils.getDataAsyn("onebox/weather/query", map, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                weatherMutableLiveData.setValue(null);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("Fragment2","response:"+response);
                Weather weather = JSON.parseObject(response, Weather.class);
                weatherMutableLiveData.setValue(weather);
            }
        });
    }

    public MutableLiveData<Weather> getWeather() {
        return weatherMutableLiveData;
    }
}