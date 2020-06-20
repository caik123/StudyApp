package com.example.study.vvmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MapViewModel extends ViewModel {
    private MutableLiveData<Integer> mPrice = new MutableLiveData<>();
    private LiveData<Integer> liveData = Transformations.switchMap(mPrice, new Function<Integer, LiveData<Integer>>() {
        @Override
        public LiveData<Integer> apply(Integer input) {
            MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
            mutableLiveData.setValue(2);
            return mutableLiveData;
        }
    });

    public void setPrice(int price) {
        mPrice.setValue(price);
    }

    public LiveData<Integer> getPrice() {
        return liveData;
    }
}
