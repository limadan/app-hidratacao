package com.example.waterapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.waterapp.databinding.GlassBinding;
import java.util.List;

public class GlassAdapter extends RecyclerView.Adapter<GlassAdapter.GlassViewHolder> {

    private List<Glass> glassList;

    public GlassAdapter(List<Glass> glassList) {
        this.glassList = glassList;
    }

    @NonNull
    @Override
    public GlassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        GlassBinding binding = DataBindingUtil.inflate(inflater, R.layout.glass, parent, false);
        return new GlassViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GlassViewHolder holder, int position) {
        Glass glass = glassList.get(position);
        GlassViewModel viewModel = new GlassViewModel(glass);
        holder.bind(viewModel);
    }

    @Override
    public int getItemCount() {
        return glassList.size();
    }

    static class GlassViewHolder extends RecyclerView.ViewHolder {
        private final GlassBinding binding;

        public GlassViewHolder(GlassBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(GlassViewModel viewModel) {
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }
}
