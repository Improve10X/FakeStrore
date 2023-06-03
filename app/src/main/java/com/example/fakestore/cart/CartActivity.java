package com.example.fakestore.cart;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.BaseActivity;
import com.example.fakestore.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends BaseActivity {
    private ActivityCartBinding binding;

    private List<CartProduct> items = new ArrayList<>();
    private CartRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Final Cart");
        setupAdapter();
        connectAdapter();
        getApi(1);
    }

    private void getApi(int cartId) {
        Call<Cart> call = service.getCartItems(cartId);
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                Toast.makeText(CartActivity.this, "", Toast.LENGTH_SHORT).show();
                adapter.updateData(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Toast.makeText(CartActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.cartRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRv.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new CartRvAdapter(items);

    }
}