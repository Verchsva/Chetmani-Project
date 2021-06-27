package com.chetmani.verchsva.gallery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chetmani.verchsva.HomePage.GalleryFragment;
import com.chetmani.verchsva.MainActivity;
import com.chetmani.verchsva.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    GalleryData[] galleryData;
    GalleryFragment context;

    public GalleryAdapter(GalleryData[] galleryData, GalleryFragment activity){
        this.galleryData=galleryData;
        this.context=activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_gallery,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final GalleryData galleryDataList= galleryData[position];
        holder.galleryImage.setImageResource(galleryDataList.getGalleryImage());

        }

    @Override
    public int getItemCount() {
        return galleryData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView galleryImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            galleryImage=itemView.findViewById(R.id.iv_gallery);
        }
    }

}
