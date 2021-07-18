package com.chetmani.verchsva.bhawDetails;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chetmani.verchsva.FullImageActivity;
import com.chetmani.verchsva.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BhawDetailsAdapter extends FirebaseRecyclerAdapter<BhawDetailsData, BhawDetailsAdapter.BhawDetailsViewHolder> {

    public BhawDetailsAdapter(@NonNull FirebaseRecyclerOptions<BhawDetailsData> options) {
        super(options);
    }

    @Override
    public void onDataChanged() {
        // Called each time there is a new data snapshot. You may want to use this method
        // to hide a loading spinner or check for the "no documents" state and update your UI.
        // ...
    }

    @Override
    public void onError(DatabaseError e) {
        // Called when there is an error getting data. You may want to update
        // your UI to display an error message to the user.
        // ...
    }


    @Override
    protected void onBindViewHolder(@NonNull BhawDetailsViewHolder holder, int position, @NonNull BhawDetailsData bhawDetailsData) {

        holder.itemName.setText(bhawDetailsData.getItemName());
        holder.bhawDetails.setText(bhawDetailsData.getBhawDetails());
        holder.bhawDetails.setBackgroundDrawable(ContextCompat.getDrawable(holder.bhawDetails.getContext(),isAbove(bhawDetailsData.getBhawDetails())?R.drawable.bhaw_details_plus:R.drawable.bhaw_details));
        holder.updateTime.setText(bhawDetailsData.getUpdatedTime());
        Glide.with(holder.ivItemLogo.getContext()).load(bhawDetailsData.getImgUrl()).into(holder.ivItemLogo);

    }

    private boolean isAbove(String bhawDetails) {
        bhawDetails=bhawDetails.toLowerCase().replaceAll("rs", "").trim();
        int value=Integer.parseInt(bhawDetails);
        if (value>=50000){
            return true;
        }

        return false;
    }


    @NonNull
    @Override
    public BhawDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bhaw_details, parent, false);
        return new BhawDetailsViewHolder(view);
    }

    public class BhawDetailsViewHolder extends RecyclerView.ViewHolder {

        ImageView ivItemLogo;
        TextView itemName, bhawDetails, updateTime;



        public BhawDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItemLogo = itemView.findViewById(R.id.imageView);
            itemName = itemView.findViewById(R.id.tv_itemName);
            bhawDetails = itemView.findViewById(R.id.tv_bhav);
            updateTime = itemView.findViewById(R.id.tv_last_update_time);
        }
    }
}
