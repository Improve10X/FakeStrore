package com.example.fakestore;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.ProductItemsBinding;
import com.example.fakestore.network.OnProductActionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductRvAdapter extends RecyclerView.Adapter<ProductRvViewHolder> {
    private List<ProductItems> productItems;
    private OnProductActionListener listener;

    void setOnProductActionListener(OnProductActionListener listener) {
        this.listener = listener;
    }

    public ProductRvAdapter(List<ProductItems> productItems) {
        this.productItems = productItems;
    }

    void updateData(List<ProductItems> productItems) {
        this.productItems = productItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProductItemsBinding binding = ProductItemsBinding.inflate(layoutInflater, parent, false);
        ProductRvViewHolder viewHolder = new ProductRvViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRvViewHolder holder, int position) {
        ProductItems productItems1 = productItems.get(position);
        holder.binding.titleTxt.setText(productItems1.getTitle());
        holder.binding.priceTxt.setText(String.valueOf(productItems1.getPrice()));
        holder.binding.ratingRb.setRating(productItems1.getRating().getRate());
        holder.binding.countTxt.setText(String.valueOf(productItems1.getRating().getCount()));
        Picasso.get().load(productItems1.getImageUrl()).into(holder.binding.posterIv);
        holder.binding.getRoot().setOnClickListener(v -> {
            listener.OnItemClick(productItems1.getId());
        });
    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }
}
