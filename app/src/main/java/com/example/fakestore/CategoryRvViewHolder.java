package com.example.fakestore;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CategoryItemBinding;

public class CategoryRvViewHolder extends RecyclerView.ViewHolder {
 CategoryItemBinding binding;
    public CategoryRvViewHolder(CategoryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
