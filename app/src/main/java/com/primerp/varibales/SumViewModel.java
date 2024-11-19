package com.primerp.varibales;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SumViewModel extends ViewModel {
    private final MutableLiveData<Integer> resultLiveData = new MutableLiveData<>();

    public LiveData<Integer> getResultLiveData() {
        return resultLiveData;
    }

    public void calculateSum(int number1, int number2) {
        int result = number1 + number2;
        resultLiveData.setValue(result);
    }
}
