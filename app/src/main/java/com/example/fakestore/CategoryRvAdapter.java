package com.example.fakestore;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CategoryItemBinding;

import java.util.List;

public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvViewHolder> {
    private List<String> categories;
    private OnServiceActionListener listener;

    void setOnServiceActionListener(OnServiceActionListener listener) {
        this.listener = listener;
    }

    public CategoryRvAdapter(List<String> categories) {
        this.categories = categories;
    }

    void setCategories(List<String> categories) {
        this.categories = categories;
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
        String category = categories.get(position);
        holder.binding.categoryItemTxt.setText(category);
        holder.binding.categoryItemTxt.setOnClickListener(v -> {
            listener.onItemClicked(category);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
