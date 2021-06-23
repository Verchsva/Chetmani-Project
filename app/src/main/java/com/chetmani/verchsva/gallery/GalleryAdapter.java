package com.chetmani.verchsva.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chetmani.verchsva.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    Context context;
    int[] galleryImages;

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView rowImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowImage= itemView.findViewById(R.id.iv_image);
        }
    }

    public GalleryAdapter(Context context, int[] galleryImages) {
        this.context = context;
        this.galleryImages = galleryImages;
    }

    @NonNull
    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_gallery,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.ViewHolder holder, int position) {

        holder.rowImage.setImageResource(galleryImages[position]);
    }

    @Override
    public int getItemCount() {
        return galleryImages.length;
    }


}
