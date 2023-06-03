package com.example.fakestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CartItemsBinding;
import com.example.fakestore.models.Product;

import java.util.Arrays;

public class CartRvAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private Cart[] cart;
    private CartRvAdapter(Cart[] cart){
        this.cart = cart;
    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemsBinding binding = CartItemsBinding.inflate(inflater,parent,false);
        CartViewHolder viewHolder = new CartViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart1 = cart[position];
   //     holder.binding.idTxt.setText(String.valueOf(item.getId()));
//        holder.binding.countTxt.setText(String.valueOf(item.getQuantity()));
//        holder.binding.textView5.setText(item.getTitle());
//        if (item.getQuantity() == 0);
//        holder.binding.increaseIb.setVisibility(View.GONE);


    }

    @Override
    public int getItemCount() {
        return cart.length;
    }
}
