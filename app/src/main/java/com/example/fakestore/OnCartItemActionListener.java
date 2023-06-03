package com.example.fakestore;

import com.example.fakestore.models.Product;

public interface OnCartItemActionListener {

    void onAddClicked(Product product);
    void  onRemoveClicked(Product product);
}
