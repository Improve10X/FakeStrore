package com.example.fakestore.productdetails;
import androidx.appcompat.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.BaseActivity;
import com.example.fakestore.databinding.ActivityProductDetailsBinding;
import com.example.fakestore.models.Product;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {
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
        Call<Product> call = service.fetchProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                binding.productTitleTxt.setText(product.getTitle());
                binding.descriptionTxt.setText(product.getDescription());
                binding.priceTxt.setText(String.valueOf(product.getPrice()));
//                binding.productRatingRb.setRating(product.getRating().getRate());
//                binding.ratingCountTxt.setText(String.valueOf(product.getRating().getRate()));
//                binding.countTxt.setText(String.valueOf(product.getRating().getCount()));
//                binding.categoryTxt.setText(product.getCategory());
                Picasso.get().load(product.getImages().get(0)).into(binding.productImageIv);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}