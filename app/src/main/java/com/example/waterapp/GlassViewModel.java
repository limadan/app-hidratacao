package com.example.waterapp;

import androidx.lifecycle.ViewModel;

public class GlassViewModel extends ViewModel {
    private Glass glass;

    public GlassViewModel(Glass glass) {
        this.glass = glass;
    }

    public Glass getGlass() {
        return glass;
    }

    public void toggleDrunk() {
        glass.toggleDrunk();
    }
}