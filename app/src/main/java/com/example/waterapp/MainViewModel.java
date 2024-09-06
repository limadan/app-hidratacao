package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Glass>> glassesList = new MutableLiveData<>();
    private MutableLiveData<String> waterIntakeText = new MutableLiveData<>();
    private MutableLiveData<String> waterDrunkText = new MutableLiveData<>();
    private MutableLiveData<String> weight = new MutableLiveData<>();

    public MutableLiveData<String> getWaterIntakeText() {
        return waterIntakeText;
    }

    public int getVolumeCopoMl() {
        return volumeCopoMl;
    }

    public MutableLiveData<List<Glass>> getGlassesList() {
        return glassesList;
    }

    private int volumeCopoMl = 500;

    public MainViewModel() {
        glassesList.setValue(new ArrayList<>());
        waterIntakeText.setValue("0");
        waterDrunkText.setValue("0");
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

    public MutableLiveData<String> getWaterDrunkText() {
        return waterDrunkText;
    }

    public void calculateWaterDrunk() {
        int totalDrunk = 0;
        List<Glass> glasses = glassesList.getValue();
        assert glasses != null;
        for (Glass g:glasses) {
            if(g.isDrunk()){
                totalDrunk+=500;
            }
        }

        waterDrunkText.postValue(Integer.toString(totalDrunk));
    }
}
