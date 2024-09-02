package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<Glass>> glassesList = new MutableLiveData<>();
    public MutableLiveData<String> waterIntakeText = new MutableLiveData<>();

    public MainViewModel() {
        glassesList.setValue(new ArrayList<>());
        waterIntakeText.setValue("0 L");
    }

    public void calculateWaterIntake() {

    }
}
