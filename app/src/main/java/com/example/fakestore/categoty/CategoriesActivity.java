package com.example.fakestore.categoty;

import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.BaseActivity;
import com.example.fakestore.databinding.ActivityCategoriesBinding;
import com.example.fakestore.models.Product;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {
    private ActivityCategoriesBinding binding;
    private CategoryRvAdapter adapter;

    private List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getApi();
        setupAdapter();
        connectAdapter();
    }

    private void getApi() {
        Call<List<Product>> call = service.FetchCategories();
       call.enqueue(new Callback<List<Product>>() {
           @Override
           public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
            adapter.setProducts(response.body());
           }

           @Override
           public void onFailure(Call<List<Product>> call, Throwable t) {

           }
       });
    }

    private void connectAdapter() {
        binding.categoryRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoryRv.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new CategoryRvAdapter(products);
    }

//    @Override
//    public void onItemClicked(String categoryName) {
//        Intent intent = new Intent(this, ProductsActivity.class);
//        intent.putExtra("categoryName", categoryName);
//        startActivity(intent);
//    }
}