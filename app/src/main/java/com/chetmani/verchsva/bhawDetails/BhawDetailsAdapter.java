package com.chetmani.verchsva.bhawDetails;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chetmani.verchsva.FullImageActivity;
import com.chetmani.verchsva.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BhawDetailsAdapter extends FirebaseRecyclerAdapter<BhawDetailsData,BhawDetailsAdapter.BhawDetailsViewHolder> {

    public BhawDetailsAdapter(@NonNull FirebaseRecyclerOptions<BhawDetailsData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BhawDetailsAdapter.BhawDetailsViewHolder holder, int position, @NonNull BhawDetailsData BhawDetailsData) {

        holder.itemName.setText(BhawDetailsData.getItemName());
        holder.bhawDetails.setText(BhawDetailsData.getBhawDetails());
        holder.updateTime.setText(BhawDetailsData.getUpdatedTime());
        Glide.with(holder.ivItemLogo.getContext()).load(BhawDetailsData.getImgUrl()).into(holder.ivItemLogo);
    }

    @NonNull
    @Override
    public BhawDetailsAdapter.BhawDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bhaw_details, parent, false);
        return new BhawDetailsViewHolder(view);
    }


    class BhawDetailsViewHolder extends RecyclerView.ViewHolder{

       ImageView ivItemLogo;
       TextView itemName,bhawDetails,updateTime;


       public BhawDetailsViewHolder(@NonNull View itemView) {
           super(itemView);
           ivItemLogo = itemView.findViewById(R.id.imageView);
           itemName = itemView.findViewById(R.id.tv_itemName);
           bhawDetails = itemView.findViewById(R.id.tv_bhav);
           updateTime = itemView.findViewById(R.id.tv_last_update_time);
       }

}}
