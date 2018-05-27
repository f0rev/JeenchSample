package com.example.ravan.coffeeshop.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ravan.coffeeshop.R;
import com.example.ravan.coffeeshop.database.entity.CoffeeEntity;

import java.util.ArrayList;
import java.util.List;

public class CoffeeItemsAdapter extends RecyclerView.Adapter<CoffeeItemsAdapter.ViewHolder> {

    private final List<CoffeeEntity> mData = new ArrayList<>();
    private Fragment mFragment;
    private CoffeeEntity mCoffeeEntity;

    CoffeeItemsAdapter(Fragment fragment) {
       mFragment= fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coffee_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        mCoffeeEntity = mData.get(position);
        Glide.with(mFragment).load(mCoffeeEntity.getItemImage()).into(holder.mItemImage);
        Glide.with(mFragment).load(mCoffeeEntity.getShopLogo()).into(holder.mShopLogo);
        holder.mItemName.setText(mCoffeeEntity.getItemName());
        holder.mItemPrice.setText(mCoffeeEntity.getItemPrice());
        holder.mShopName.setText(mCoffeeEntity.getShopName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<CoffeeEntity> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final ImageView mItemImage;
        final ImageView mShopLogo;
        final TextView mItemName;
        final TextView mItemPrice;
        final TextView mShopName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mItemImage =  view.findViewById(R.id.item_image);
            mShopLogo =  view.findViewById(R.id.shop_logo);
            mItemName =  view.findViewById(R.id.item_name);
            mItemPrice =  view.findViewById(R.id.item_price);
            mShopName =  view.findViewById(R.id.shop_name);
        }
    }


}
