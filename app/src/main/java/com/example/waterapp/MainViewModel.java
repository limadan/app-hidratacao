package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<Glass>> glassesList = new MutableLiveData<>();
    public MutableLiveData<String> waterIntakeText = new MutableLiveData<>();
    public MutableLiveData<String> weight = new MutableLiveData<>();
    public int volumeCopoMl = 500;

    public MainViewModel() {
        glassesList.setValue(new ArrayList<>());
        waterIntakeText.setValue("0 L");
    }

    public MutableLiveData<String> getWeight(){
        return weight;
    }

    public void calculateWaterIntake() {
        int peso = Integer.parseInt(weight.getValue());
        int totalMl = peso * 35;
        int numCopos = (int) Math.ceil((double) totalMl / volumeCopoMl);
        List<Glass> glasses = new ArrayList<>();
        for (int i = 0; i < numCopos; i++) {
            glasses.add(new Glass(volumeCopoMl));
        }

        glassesList.postValue(glasses);
        waterIntakeText.setValue(Double.toString ((double)totalMl/(double)1000));
    }
}
