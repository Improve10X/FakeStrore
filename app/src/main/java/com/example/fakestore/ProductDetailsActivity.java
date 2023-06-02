package com.example.fakestore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.databinding.ActivityProductDetailsBinding;
import com.example.fakestore.databinding.ActivityProductsBinding;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeApiService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {
    private ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int id = intent.getIntExtra("productId", 0);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ProductDetails");
        actionBar.setDisplayHomeAsUpEnabled(true);
        getProductDetails(id);
    }

    private void getProductDetails(int productId) {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<ProductItems> call = service.getProductDetails(productId);
        call.enqueue(new Callback<ProductItems>() {
            @Override
            public void onResponse(Call<ProductItems> call, Response<ProductItems> response) {
                ProductItems productItems = response.body();
                binding.productTitleTxt.setText(productItems.getTitle());
                binding.descriptionTxt.setText(productItems.getDescription());
                binding.priceTxt.setText(String.valueOf(productItems.getPrice()));
                binding.productRatingRb.setRating(productItems.getRating().getRate());
                binding.ratingCountTxt.setText(String.valueOf(productItems.getRating().getRate()));
                binding.countTxt.setText(String.valueOf(productItems.getRating().getCount()));
                binding.categoryTxt.setText(productItems.getCategory());
                Picasso.get().load(productItems.getImageUrl()).into(binding.productImageIv);
            }

            @Override
            public void onFailure(Call<ProductItems> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}