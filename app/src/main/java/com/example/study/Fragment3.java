package com.example.study;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.study.view.CardItem;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {
    private View view;
    private LinearLayout layout;
    private CardItem cardItem;
    private ImageView imageView;

    private boolean isFirstLoad = true;

    public Fragment3() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("test", "onCreate3");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("test", "onCreateViewe3");
        if (view != null) {
            return view;
        }
        view = inflater.inflate(R.layout.fragment_3, container, false);
        layout = view.findViewById(R.id.layout);
        cardItem = view.findViewById(R.id.card_item);
        imageView = cardItem.findViewById(R.id.avatar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("test", "onViewCreated3");
        super.onViewCreated(view, savedInstanceState);
        cardItem.setData(R.mipmap.ic_launcher, "技术最TOP", "扒最前沿科技动态，聊最TOP编程技术~");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Activity3.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                            imageView,
                            "activityTransform")
                            .toBundle();
                    intent.putExtra("bundle",bundle);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //懒加载
        if (isFirstLoad) {
            isFirstLoad = false;
            Log.e("test", "第3个Fragment懒加载");
            //lazyLoad();
        }
    }
}
