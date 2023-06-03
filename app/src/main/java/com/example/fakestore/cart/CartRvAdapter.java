package com.example.fakestore.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CartItemsBinding;

import java.util.List;

public class CartRvAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private List<CartProduct> cart;

    CartRvAdapter(List<CartProduct> cart) {
        this.cart = cart;
    }

    void updateData(List<CartProduct> cart) {
        this.cart = cart;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemsBinding binding = CartItemsBinding.inflate(inflater, parent, false);
        CartViewHolder viewHolder = new CartViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartProduct cart1 = cart.get(position);
        holder.binding.idTxt.setText(String.valueOf(cart1.getProductId()));
        holder.binding.countTxt.setText(String.valueOf(cart1.getQuantity()));
        if (cart1.getQuantity() == 0) {
            holder.binding.decreaseIb.setVisibility(View.GONE);
            holder.binding.countTxt.setVisibility(View.GONE);
        } else {
            holder.binding.countTxt.setText(cart1.getQuantity() + "");
            holder.binding.decreaseIb.setVisibility(View.VISIBLE);
            holder.binding.countTxt.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }
}
