package com.example.study.net;

/**
 * @author GhostKang
 * @description:
 * @date :2020/5/29 16:13
 */
public interface NetChangeObserver {
    /**
     * 网络连接成功
     */
    void onConnected(String type);
    /**
     * 网络断开
     */
    void onDisConnected();
}
