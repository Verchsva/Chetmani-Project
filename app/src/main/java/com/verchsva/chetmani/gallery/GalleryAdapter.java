package com.verchsva.chetmani.gallery;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.verchsva.chetmani.FullImageActivity;
import com.verchsva.chetmani.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh Srivastava on 22-Jul-2020 11:31 PM.
 * Project : SplashScreenWithLogIn
 * Copyright (c) 2020  All rights reserved.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private final List<String> mItems;

    public GalleryAdapter() {
        this.mItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, final int position) {
        Picasso.get().load(mItems.get(position)).into(holder.ivImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = FullImageActivity.getStartIntent(view.getContext(), mItems.get(position));
                view.getContext().startActivity(startIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItems(List<String> items) {
        this.mItems.clear();
        if (items != null) {
            this.mItems.addAll(items);
        }
        notifyDataSetChanged();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView ivImage;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
    }
}
