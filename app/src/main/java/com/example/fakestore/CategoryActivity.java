package com.example.fakestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.databinding.ActivityCategoryBinding;
import com.example.fakestore.models.Categories;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeApiService;
import com.example.fakestore.network.OnServiceActionListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity implements OnServiceActionListener {
    private ActivityCategoryBinding binding;
    private CategoryRvAdapter adapter;

    private List<String> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getApi();
        setupAdapter();
        connectAdapter();
    }

    private void getApi() {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<String>> call = service.FetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Toast.makeText(CategoryActivity.this, "Success", Toast.LENGTH_SHORT).show();
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.categoryRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoryRv.setAdapter(adapter);
    }

    private void setupAdapter() {

        adapter = new CategoryRvAdapter(categories);
        adapter.setOnServiceActionListener(this);
    }

    @Override
    public void onItemClicked(String categoryName) {
        Intent intent = new Intent(this,ProductsActivity.class);
        intent.putExtra("categoryName",categoryName);
        startActivity(intent);
    }
}