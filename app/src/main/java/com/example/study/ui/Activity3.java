package com.example.study.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.study.R;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        final ImageView imageView = findViewById(R.id.avatar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3.this, Activity4.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Log.e("test3", "version:" + Build.VERSION.SDK_INT);
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(Activity3.this,
                            imageView,
                            "activityTransform")
                            .toBundle();
                    intent.putExtra("bundle", bundle);
                }
                startActivity(intent);
            }
        });
    }
}