package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GlassViewModel extends ViewModel {
    public MutableLiveData<Integer> imagemCopo;

    private Glass glass;

    public GlassViewModel(Glass glass) {
        this.glass = glass;
    }

    public Glass getGlass() {
        return glass;
    }

    public void toggleDrunk() {
        glass.toggleDrunk();
        if(glass.isDrunk()){
            imagemCopo.postValue(R.drawable.ic_glass_empty);
        }else{
            imagemCopo.postValue(R.drawable.ic_glass_full);
        }
    }
}