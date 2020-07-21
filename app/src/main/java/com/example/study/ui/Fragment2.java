package com.example.study.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.study.R;
import com.example.study.bean.Weather;
import com.example.study.databinding.Fragment2Binding;
import com.example.study.http.HttpClient;
import com.example.study.http.HttpUtils;
import com.example.study.http2.ApiUtils;
import com.example.study.inter.ApiWanService;
import com.example.study.view.RoundProgressBar;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    private Fragment2Binding mBinding;
    private Fragment2ViewModel viewModel;
    boolean isFirstLoad = true;
    private Weather mWeather;
    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("test", "onCreate2");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("test", "onCreateView2");
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_2, container, false);
        mWeather = new Weather();
        mBinding.setWeather(mWeather);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("test", "onViewCreated2");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new Fragment2ViewModel();
        // TODO: Use the ViewModel
        viewModel.getWeather().observe(getViewLifecycleOwner(), new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {
                Log.e("Fragment2",weather.getReason());
                mWeather.setReason(weather.getReason());
                //weather.setReason(weather.getReason());
            }
        });
        viewModel.queryWeather("武汉");
    }



    @Override
    public void onResume() {
        super.onResume();
        //懒加载
        if (isFirstLoad) {
            isFirstLoad = false;
            Log.e("test", "第2个Fragment懒加载");
            //lazyLoad();
            mBinding.roundProgressBar.setOnPressListener(new RoundProgressBar.OnPressListener() {
                @Override
                public void onPress(View view) {
                    Toast.makeText(getContext(), "onPress", Toast.LENGTH_SHORT).show();
                    // 由于我用在开屏页，有定时跳转策略，因此点击后需要移除
                    //handler.removeCallbacksAndMessages(null);
                    // 这里你可以实现自己的逻辑
                }
            });

            mBinding.roundProgressBar.startSlide(5000, new RoundProgressBar.SlideCallback() {
                @Override
                public void onProgress(int curProgress, int maxProgress) {

                }
            });
        }
    }
}
