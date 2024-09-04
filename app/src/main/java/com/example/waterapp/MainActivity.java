package com.example.waterapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterapp.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setMainViewModel(mainViewModel);
        binding.setLifecycleOwner(this);

        GlassAdapter adapter = new GlassAdapter(mainViewModel.glassesList.getValue());
        binding.glassesRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        binding.glassesRecyclerView.setAdapter(adapter);
    }

    @BindingAdapter("app:glassList")
    public static void setGlassList(RecyclerView rv, List<Glass> glass_list){
        rv.setAdapter(new GlassAdapter(glass_list));
    }
}
