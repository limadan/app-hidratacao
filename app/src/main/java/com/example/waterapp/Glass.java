package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Glass {
    private int amount;
    private boolean isDrunk;

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
    }
}