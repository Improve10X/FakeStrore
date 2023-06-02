package com.example.fakestore.network;

import com.example.fakestore.ProductItems;
import com.example.fakestore.models.Categories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {
    @GET ("products/categories")
    Call<List<String>> FetchCategories();
    @GET ("products/category/{categoryName}")
    Call<List<ProductItems>> getProduct(@Path("categoryName")String categoryName);
    @GET("products/{productId}")
    Call<ProductItems> getProductDetails(@Path("productId") int productId);
}
