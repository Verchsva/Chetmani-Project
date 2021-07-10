package com.chetmani.verchsva.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chetmani.verchsva.R;
import com.chetmani.verchsva.newsUpdates.NewsUpdatesAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class GalleryListViewAdapter extends FirebaseRecyclerAdapter<GalleryListViewData, GalleryListViewAdapter.GalleryListViewViewHolder> {

    public GalleryListViewAdapter(@NonNull FirebaseRecyclerOptions<GalleryListViewData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull GalleryListViewViewHolder holder, int position, @NonNull GalleryListViewData galleryListViewData) {

        holder.itemList.setText(galleryListViewData.getItemCategory());

    }

    @NonNull
    @Override
    public GalleryListViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery_list, parent, false);
        return new GalleryListViewViewHolder(view);
    }

    public class GalleryListViewViewHolder extends RecyclerView.ViewHolder {
        TextView itemList;
        public GalleryListViewViewHolder(@NonNull View itemView) {
            super(itemView);
            itemList=itemView.findViewById(R.id.tv_gallery_item_list);

        }
    }
}
