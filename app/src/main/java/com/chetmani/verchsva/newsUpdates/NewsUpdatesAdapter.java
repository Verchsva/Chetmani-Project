package com.chetmani.verchsva.newsUpdates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chetmani.verchsva.R;
import com.chetmani.verchsva.bhawDetails.BhawDetailsAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class NewsUpdatesAdapter extends FirebaseRecyclerAdapter<NewsUpdatesData, NewsUpdatesAdapter.NewsUpdatesViewHolder> {


    public NewsUpdatesAdapter(@NonNull FirebaseRecyclerOptions<NewsUpdatesData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NewsUpdatesAdapter.NewsUpdatesViewHolder holder, int position, @NonNull NewsUpdatesData newsUpdatesData) {

        holder.heading.setText(newsUpdatesData.getHeading());
        holder.description.setText(newsUpdatesData.getDescription());
        holder.time.setText(newsUpdatesData.getTime());

    }

    @NonNull
    @Override
    public NewsUpdatesAdapter.NewsUpdatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_updates, parent, false);
        return new NewsUpdatesViewHolder(view);
    }

    public class NewsUpdatesViewHolder extends RecyclerView.ViewHolder {

        TextView heading,description,time;

        public NewsUpdatesViewHolder(@NonNull View itemView) {
            super(itemView);

            heading=itemView.findViewById(R.id.tv_updates_heading);
            description=itemView.findViewById(R.id.tv_updates_description);
            time=itemView.findViewById(R.id.tv_updates_time);

        }
    }
}
