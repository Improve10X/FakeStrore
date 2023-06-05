package com.example.fakestore.categoty;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CategoryItemBinding;
import com.example.fakestore.models.Product;

import java.util.List;

public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvViewHolder> {
    private List<Product> products;
    private OnServiceActionListener listener;

    void setOnServiceActionListener(OnServiceActionListener listener) {
        this.listener = listener;
    }

    public CategoryRvAdapter(List<Product> products) {
        this.products = products;
    }

    void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CategoryItemBinding binding = CategoryItemBinding.inflate(inflater, parent, false);
        CategoryRvViewHolder viewHolder = new CategoryRvViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRvViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.nameTxt.setText(product.getName());
        holder.binding.nameTxt.setOnClickListener(v -> {
            listener.onItemClicked(product);
        });
    }
    @Override
    public int getItemCount() {
        return products.size();
    }
}
