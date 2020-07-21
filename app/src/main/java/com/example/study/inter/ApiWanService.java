package com.example.study.inter;

import com.example.study.bean.BannerResp;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiWanService {
    @GET("banner/json")
    Observable<BannerResp> getWanAndroidBanner();
}
