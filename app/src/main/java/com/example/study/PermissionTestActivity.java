package com.example.study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

/***
 * 申请权限类
 */
public class PermissionTestActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final String TAG = PermissionTestActivity.class.getSimpleName();
    private static final int RC_CAMERA_AND_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_test);
        getPermissionAndDoWork();
    }

    private void getPermissionAndDoWork() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Log.e(TAG, "hasPermissions");
        } else {
            EasyPermissions.requestPermissions(this, "请求存储空间和相机权限", RC_CAMERA_AND_STORAGE, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if (requestCode == RC_CAMERA_AND_STORAGE) {
            if (perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE) && perms.contains(Manifest.permission.CAMERA)) {
                Toast.makeText(this, "两个权限都获取到了", Toast.LENGTH_SHORT).show();
                //TODO doWork
            }
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (requestCode == RC_CAMERA_AND_STORAGE) {
            if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
                //new AppSettingsDialog.Builder(this).build().show();
                new AppSettingsDialog
                        .Builder(this)
                        .setRationale("此功能需要存储空间和相机权限，否则无法正常使用，是否打开设置")
                        .setPositiveButton("好")
                        .setNegativeButton("不行")
                        .build()
                        .show();
            }
        }

    }
}