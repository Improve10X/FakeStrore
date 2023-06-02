package com.example.fakestore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFakeApiService();
    }

    private void createFakeApiService(){
        service = new FakeApi().fakeApiService();
    }
}
