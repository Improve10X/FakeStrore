package com.example.fakestore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.databinding.ActivityProductsBinding;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {
    private ActivityProductsBinding binding;
    private ProductRvAdapter adapter;
    private List<ProductItems> productItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String category = intent.getStringExtra("categoryName");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("productItems");
        actionBar.setDisplayHomeAsUpEnabled(true);
        setAdapter();
        connectAdapter();
        productApi(category);
    }

    private void productApi(String category) {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<ProductItems>> call = service.getProduct(category);
        call.enqueue(new Callback<List<ProductItems>>() {
            @Override
            public void onResponse(Call<List<ProductItems>> call, Response<List<ProductItems>> response) {
                Toast.makeText(ProductsActivity.this, "Success", Toast.LENGTH_SHORT).show();
                adapter.updateData(response.body());

            }

            @Override
            public void onFailure(Call<List<ProductItems>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void connectAdapter() {
        binding.productItemRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productItemRv.setAdapter(adapter);
    }

    private void setAdapter() {
        adapter = new ProductRvAdapter(productItems);
        adapter.updateData(productItems);
    }
}