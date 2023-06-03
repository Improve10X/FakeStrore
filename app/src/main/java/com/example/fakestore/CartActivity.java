package com.example.fakestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fakestore.databinding.ActivityCartBinding;
import com.example.fakestore.databinding.ActivityCategoriesBinding;
import com.example.fakestore.models.Product;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;

    private Product[] items;
    private CartRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Final Cart");
        setupAdapter();
        connectAdapter();
    }

    private void connectAdapter() {

    }

    private void setupAdapter() {

    }
}