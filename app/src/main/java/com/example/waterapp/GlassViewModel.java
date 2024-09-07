package com.example.waterapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GlassViewModel extends ViewModel {
    public LiveData<Integer> getImagemCopo() {
        return imagemCopo;
    }

    public MainViewModel mainViewModel;

    private MutableLiveData<Integer> imagemCopo;
    private MutableLiveData<String> mlCopo;

    private Glass glass;

    public GlassViewModel(Glass glass, MainViewModel mainViewModel) {
        this.glass = glass;
        this.mainViewModel = mainViewModel;
        this.imagemCopo = new MutableLiveData<>();
        this.mlCopo = new MutableLiveData<>(Integer.toString(glass.getAmount()) + "ml");

        if(glass.isDrunk()){
            imagemCopo.postValue(R.drawable.ic_glass_empty);
        }else{
            imagemCopo.postValue(R.drawable.ic_glass_full);
        }
    }

    public Glass getGlass() {
        return glass;
    }

    public MutableLiveData<String> getMlCopo() {
        return mlCopo;
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