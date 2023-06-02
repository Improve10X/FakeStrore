package com.example.fakestore;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.ProductItemsBinding;

public class ProductRvViewHolder extends RecyclerView.ViewHolder {
    ProductItemsBinding binding;
    public ProductRvViewHolder(ProductItemsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
