package com.example.study.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author GhostKang
 * @description:
 * @date :2020/5/29 16:17
 */
public class NetStateReceiver extends BroadcastReceiver {
    private static final String TAG = NetStateReceiver.class.getSimpleName();
    NetChangeObserver mNetChangeObserver;
    private String type;

    public NetStateReceiver() {
        this.type = NetType.NONE;
    }

    public void setListener(NetChangeObserver observer) {
        mNetChangeObserver = observer;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            Log.e(TAG, "广播异常了");
            return;
        }
        if (intent.getAction().equalsIgnoreCase(Constants.ANDROID_NET_CHANGE_ACTION)) {
            Log.e(TAG, "网络状态变化了");
            type = NetWorkUtils.getNetworkType();
            if (NetWorkUtils.isNetWorkAvailable()) {
                Log.i(TAG, "网络连上了");
                mNetChangeObserver.onConnected(type);
            } else {
                Log.i(TAG, "网络断开了");
                mNetChangeObserver.onDisConnected();
            }
        }
    }
}
