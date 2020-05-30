package com.example.study.camera;

import android.os.Bundle;
import android.widget.Toast;

import com.example.study.BaseActivity;
import com.example.study.R;
import com.laifeng.sopcastsdk.camera.CameraListener;
import com.laifeng.sopcastsdk.ui.CameraLivingView;

public class CameraActivity extends BaseActivity {
    CameraLivingView  mLFLiveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mLFLiveView = findViewById(R.id.liveView);
        mLFLiveView.init();
        mLFLiveView.setCameraOpenListener(new CameraListener() {
            @Override
            public void onOpenSuccess() {
                Toast.makeText(CameraActivity.this, "摄像头开启成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onOpenFail(int error) {
                Toast.makeText(CameraActivity.this, "摄像头开启失败", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCameraChange() {
                Toast.makeText(CameraActivity.this, "摄像头切换", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLFLiveView.pause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLFLiveView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLFLiveView.stop();
        mLFLiveView.release();
    }
}
