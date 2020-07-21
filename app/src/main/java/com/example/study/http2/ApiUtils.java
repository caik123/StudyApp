package com.example.study.http2;

import android.content.Context;
import android.util.Log;

import com.example.study.http.HttpUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.IOException;
import java.util.Map;

import okhttp3.Response;


public class ApiUtils {

    /***
     * get方法 异步获取数据
     * @param url url
     * @param map 参数
     * @param stringCallback 回调
     */
    public static void getDataAsyn( String url, Map<String, String> map, StringCallback stringCallback) {

        GetBuilder builder = OkHttpUtils.get();
        for (Map.Entry<String, String> vo : map.entrySet()) {
            builder.addParams(vo.getKey(), vo.getValue());
        }
        builder.addParams("key","afc28ae28c6f1b520dab5d1ed537f6c0");
        RequestCall requestCall = builder
                .url(HttpUtils.BASE_URL_WEATHER + url)
                .build();
        requestCall.execute(stringCallback);
        Log.i("ApiUtils", "请求url:" + requestCall.getRequest().url());
    }

    /***
     * get方法 同步获取数据
     * @param context 上下文
     * @param map 参数
     * @param url url
     * @return
     */
    public static String getDataSyn(Context context, String url, Map<String, String> map) {
        String result = null;

        GetBuilder builder = OkHttpUtils.get();
        for (Map.Entry<String, String> vo : map.entrySet()) {
            builder.addParams(vo.getKey(), vo.getValue());
        }
        try {
            RequestCall requestCall = builder
                    .url(HttpUtils.BASE_URL_WAN_ANDROID + url)
                    .build()
                    .connTimeOut(120000);
            Response response = requestCall.execute();
            Log.i("ApiUtils", "请求url:" + requestCall.getRequest().url());
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /***
     * 异步获取数据
     * @param context 上下文
     * @param url 完整的拼接url
     * @param stringCallback 回调
     */
    public static void getData(Context context, String url, StringCallback stringCallback) {
        OkHttpUtils
                .get()
                .url(HttpUtils.BASE_URL_WAN_ANDROID + url)
                .build()
                .execute(stringCallback);
    }

}
