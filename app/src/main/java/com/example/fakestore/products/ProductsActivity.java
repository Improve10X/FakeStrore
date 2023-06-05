package com.example.fakestore.products;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.GridLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.BaseActivity;
import com.example.fakestore.databinding.ActivityProductsBinding;
import com.example.fakestore.models.Product;
import com.example.fakestore.productdetails.ProductDetailsActivity;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity implements OnProductActionListener {
    private ActivityProductsBinding binding;
    private ProductRvAdapter adapter;
    private List<Product> productItems = new ArrayList<>();
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("productItems");
        actionBar.setDisplayHomeAsUpEnabled(true);
        setupAdapter();
        connectAdapter();
    }

    private void getProductsApi(Product product) {
        Call<List<Product>> call = service.getProducts(product.getId());
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                adapter.updateData(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.productItemRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productItemRv.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new ProductRvAdapter(productItems);
        adapter.setOnProductActionListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        getProductsApi(product);
    }

    @Override
    public void OnItemClick(int productId) {
        Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
        intent.putExtra("productId",productId);
        startActivity(intent);
    }
    }