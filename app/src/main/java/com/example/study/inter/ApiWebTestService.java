package com.example.study.inter;

import com.example.study.bean.BannerResp;
import com.example.study.bean.Base2Result;
import com.example.study.bean.UserInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiWebTestService {
    @POST("userInfo/register")
    Observable<Base2Result> register(@Body UserInfo userInfo);
}
