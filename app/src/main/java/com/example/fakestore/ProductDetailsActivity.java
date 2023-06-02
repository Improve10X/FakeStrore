package com.example.fakestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fakestore.databinding.ActivityProductDetailsBinding;
import com.example.fakestore.databinding.ActivityProductsBinding;

public class ProductDetailsActivity extends AppCompatActivity {
private ActivityProductDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}