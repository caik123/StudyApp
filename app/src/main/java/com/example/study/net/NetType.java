package com.example.study.net;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author GhostKang
 * @description: 网络类型, 替代枚举类型
 * @date :2020/5/29 16:13
 */

@Retention(RetentionPolicy.SOURCE)
@StringDef({NetType.AUTO, NetType.WIFI, NetType.CMNET, NetType.CMWAP,NetType.NONE})
public @interface NetType {
    //有网络，包括Wifi/gprs
    String AUTO = "AUTO";
    //wifi
    String WIFI = "WIFI";
    //PC/笔记本/PDA
    String CMNET = "CMNET";
    //手机端
    String CMWAP = "CMWAP";
    //没有网络
    String NONE = "NONE";
}
