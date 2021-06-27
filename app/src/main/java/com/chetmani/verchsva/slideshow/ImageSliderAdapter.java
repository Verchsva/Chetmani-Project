package com.chetmani.verchsva.slideshow;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chetmani.verchsva.HomePage.HomeFragment;
import com.squareup.picasso.Picasso;
import com.chetmani.verchsva.FullImageActivity;
import com.chetmani.verchsva.R;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHolder> {

    public Context context;
    List<DataForImageSlider> dataForImageSlider;

    public ImageSliderAdapter(Context context, List<DataForImageSlider> dataForImageSlider) {
        this.context = context;
        this.dataForImageSlider = dataForImageSlider;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_slideshow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataForImageSlider dt=dataForImageSlider.get(position);
        Glide.with(context).load(dt.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataForImageSlider.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}

