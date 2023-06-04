package com.example.fakestore.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.ProductItemsBinding;
import com.example.fakestore.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

//public class ProductRvAdapter extends RecyclerView.Adapter<ProductRvViewHolder> {
//    private List<Product> productItems;
//    private OnProductActionListener listener;
//
//    void setOnProductActionListener(OnProductActionListener listener) {
//        this.listener = listener;
//    }
//
//    public ProductRvAdapter(List<Product> productItems) {
//        this.productItems = productItems;
//    }
//
//    void updateData(List<Product> productItems) {
//        this.productItems = productItems;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ProductRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        ProductItemsBinding binding = ProductItemsBinding.inflate(layoutInflater, parent, false);
//        ProductRvViewHolder viewHolder = new ProductRvViewHolder(binding);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ProductRvViewHolder holder, int position) {
//        Product product = productItems.get(position);
//        holder.binding.titleTxt.setText(product.getTitle());
//        holder.binding.priceTxt.setText(String.valueOf(product.getPrice()));
//        holder.binding.ratingRb.setRating(product.getRating().getRate());
//        holder.binding.countTxt.setText(String.valueOf(product.getRating().getCount()));
//        Picasso.get().load(product.getImageUrl()).into(holder.binding.posterIv);
//        holder.binding.getRoot().setOnClickListener(v -> {
//            listener.OnItemClick(product.getId());
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return productItems.size();
//    }
//}
