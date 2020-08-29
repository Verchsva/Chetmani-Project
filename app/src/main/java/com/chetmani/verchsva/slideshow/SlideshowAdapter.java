package com.chetmani.verchsva.slideshow;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.chetmani.verchsva.FullImageActivity;
import com.chetmani.verchsva.R;

import java.util.ArrayList;
import java.util.List;

public class SlideshowAdapter extends RecyclerView.Adapter<SlideshowAdapter.SlideshowViewHolder> {

    private final List<String> mItems;

    public SlideshowAdapter() {
        this.mItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public SlideshowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideshowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slideshow, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SlideshowViewHolder holder, final int position) {
        Picasso.get().load(mItems.get(position)).into(holder.ivSlideshowImage);
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
        Log.v("SA", "***** items " + items);
        this.mItems.clear();
        if (items != null) {
            this.mItems.addAll(items);
        }
        notifyDataSetChanged();
    }

    public class SlideshowViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView ivSlideshowImage;

        public SlideshowViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSlideshowImage = itemView.findViewById(R.id.iv_slideshow_image);
        }
    }
}

