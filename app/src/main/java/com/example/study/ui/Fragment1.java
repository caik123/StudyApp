package com.example.study.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.study.R;
import com.example.study.bean.BannerResp;
import com.example.study.bean.Base2Result;
import com.example.study.bean.UserInfo;
import com.example.study.http.HttpClient;
import com.example.study.tree.TreeActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 结论：从源码中得到的结论是，Fragment数据的初始化应当在onResume方法中执行，可实现懒加载。
 */
public class Fragment1 extends Fragment {
    private static final String TAG = Fragment1.class.getSimpleName();
    private View view;
    private boolean isFirstLoad = true;

    public Fragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("test", "onCreate1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("test", "onCreateView1");
        // Inflate the layout for this fragment
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_1, container, false);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TreeActivity.class));
            }
        });
        view.findViewById(R.id.doubleClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//权限
                startActivity(new Intent(getContext(), PermissionTestActivity.class));
            }
        });

        //字体图标
        Typeface iconfont = Typeface.createFromAsset(getActivity().getAssets(), "iconfont/iconfont.ttf");
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setTypeface(iconfont);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated");
        CameraHandlerThread cameraHandlerThread = new CameraHandlerThread("camera thread");
        synchronized (cameraHandlerThread) {
            cameraHandlerThread.openCamera();
        }
        Log.e(TAG, "count:" + count);
        Disposable disposable = HttpClient.Builder.getWanAndroidServer().getWanAndroidBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerResp>() {
                    @Override
                    public void accept(BannerResp bannerResp) throws Exception {
                        Log.e("Fragment1", "bannerResp:" + bannerResp);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("Fragment1", "throwable:" + throwable.getMessage());
                    }
                });
        UserInfo userInfo = new UserInfo();
        userInfo.setNumId(16);
        userInfo.setName("瞎掰");
        Disposable disposable2 = HttpClient.Builder.getWebTestServer().register(userInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Base2Result>() {
                    @Override
                    public void accept(Base2Result base2Result) throws Exception {
                        Log.e("Fragment1", "base2Result:" + base2Result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("Fragment1", "throwable:" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        //懒加载
        if (isFirstLoad) {
            isFirstLoad = false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止加载
        //stopLoad();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    private int count = 1;

    public class CameraHandlerThread extends HandlerThread {

        private Handler mHandler;

        public CameraHandlerThread(String name) {
            super(name);
            start();
            mHandler = new Handler(getLooper());
            Log.e(TAG, "name:" + name);
        }

        private void notifyCameraOpened() {
            synchronized (this) {
                notify();
            }
        }

        public void openCamera() {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, "openCamera");
                    doOpenFromCamera();
                    notifyCameraOpened();
                }
            });

            try {
                wait();
            } catch (InterruptedException ex) {
                Log.e(TAG, "wait was interrupted");
            }
        }

        private void doOpenFromCamera() {
            SystemClock.sleep(3000);
            Log.e(TAG, "doOpenFromCamera 3000 later");
            count++;
        }
    }
}
