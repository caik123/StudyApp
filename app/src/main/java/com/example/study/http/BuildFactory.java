package com.example.study.http;

/**
 * @author jingbin
 * @data 2018/2/9
 * @Description
 */

public class BuildFactory {

    private static BuildFactory instance;
    private Object wanAndroidHttps;
    private Object webHttp;
    private Object webTestHttp;

    public static BuildFactory getInstance() {
        if (instance == null) {
            synchronized (BuildFactory.class) {
                if (instance == null) {
                    instance = new BuildFactory();
                }
            }
        }
        return instance;
    }

    public <T> T create(Class<T> a, String type) {
        switch (type) {
            case HttpUtils.BASE_URL_API_WEB:
                if (webHttp == null) {
                    synchronized (BuildFactory.class) {
                        if (webHttp == null) {
                            webHttp = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) webHttp;
            case HttpUtils.BASE_URL_TEST:
                if (webTestHttp == null) {
                    synchronized (BuildFactory.class) {
                        if (webTestHttp == null) {
                            webTestHttp = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) webTestHttp;
            default:
                if (wanAndroidHttps == null) {
                    synchronized (BuildFactory.class) {
                        if (wanAndroidHttps == null) {
                            wanAndroidHttps = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) wanAndroidHttps;
        }
    }
}
