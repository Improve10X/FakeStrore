package com.example.fakestore.cart;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CartItemsBinding;

public class CartViewHolder extends RecyclerView.ViewHolder {
    CartItemsBinding binding;
    public CartViewHolder(CartItemsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
