package com.example.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.study.R;

/**
 * @author GhostKang
 * @description:
 * @date :2020/6/4 8:52
 */
public class CardItem extends FrameLayout {

    private ImageView ivAvatar;
    private TextView tvName;
    private TextView tvDesc;

    public CardItem(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CardItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CardItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, null, false);
        ivAvatar = view.findViewById(R.id.avatar);
        tvName = view.findViewById(R.id.name);
        tvDesc = view.findViewById(R.id.des);

        addView(view);
    }

    public void setData(int imageAvatarRes, String name, String desc) {
        ivAvatar.setImageResource(imageAvatarRes);
        tvName.setText(name);
        tvDesc.setText(desc);
    }
}
