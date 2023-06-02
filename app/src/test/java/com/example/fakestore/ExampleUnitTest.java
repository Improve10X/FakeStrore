package com.example.fakestore;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.fakestore.models.Categories;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategoryName() throws IOException {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<String>> call = service.FetchCategories();
        List<String> ab = call.execute().body();
        assertNotNull(ab);
        assertFalse(ab.isEmpty());
        System.out.println(new Gson().toJson(ab));
    }

    @Test
    public void getProducts() throws IOException {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<ProductItems>> call = service.getProduct("jewelery");
        List<ProductItems> abc = call.execute().body();
        assertNotNull(abc);
        assertFalse(abc.isEmpty());
        System.out.println(new Gson().toJson(abc));
    }
    @Test
    public void fetchProductDetails() throws IOException {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<ProductItems> call = service.getProductDetails(2);
        ProductItems productItems = call.execute().body();
        assertNotNull(productItems);
        System.out.println(new Gson().toJson(productItems));

    }
}