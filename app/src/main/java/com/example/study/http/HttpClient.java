package com.example.study.http;

import com.example.study.inter.ApiWanService;
import com.example.study.inter.ApiWebTestService;

public interface HttpClient {

    class Builder {

        public static ApiWanService getWanAndroidServer() {
            return BuildFactory.getInstance().create(ApiWanService.class, HttpUtils.BASE_URL_WAN_ANDROID);
        }

        public static ApiWebTestService getWebTestServer() {
            return BuildFactory.getInstance().create(ApiWebTestService.class, HttpUtils.BASE_URL_TEST);
        }
    }
}
