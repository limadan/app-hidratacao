package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Glass extends ViewModel {
    private int amount;
    private boolean isDrunk;

    public MutableLiveData<Integer> imagemCopo;

    public Glass(int amount) {
        this.amount = amount;
        this.isDrunk = false;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDrunk() {
        return isDrunk;
    }

    public void toggleDrunk() {
        this.isDrunk = !this.isDrunk;
        if(this.isDrunk()){
            imagemCopo.postValue(R.drawable.ic_glass_empty);
        }else{
            imagemCopo.postValue(R.drawable.ic_glass_full);
        }
    }
}