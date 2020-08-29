package com.chetmani.verchsva;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.chetmani.verchsva.slideshow.SlideshowAdapter;

import java.util.ArrayList;
import java.util.List;

public class ftab extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "fTab";
    ViewFlipper v_flipper;
    ImageView image;
    TextView a, b, c, d, e, f, g, h, i, j, k;
    DatabaseReference reff;
    SwipeRefreshLayout refreshLayout;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_tab1home, container, false);

        a = (TextView) root.findViewById(R.id.tableId2);
        b = (TextView) root.findViewById(R.id.tableId4);
        c = (TextView) root.findViewById(R.id.tableId6);
        e = (TextView) root.findViewById(R.id.tableHeading1);
        f = (TextView) root.findViewById(R.id.tableHeading3);
        g = (TextView) root.findViewById(R.id.tableHeading5);
        i = (TextView) root.findViewById(R.id.news_feed);
        j = (TextView) root.findViewById(R.id.btmText);
        k = (TextView) root.findViewById(R.id.tableHeading);

        TextView textView = root.findViewById(R.id.news_feed);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);

        refreshLayout = root.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onRefresh();

        RecyclerView rvSlideshow = getView().findViewById(R.id.rv_slideshow_images);
        rvSlideshow.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        final SlideshowAdapter slideshowAdapter = new SlideshowAdapter();
        rvSlideshow.setAdapter(slideshowAdapter);

        DatabaseReference databaseReference = Utils.getInstance().getReference().child("SLIDESHOW");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.v(TAG, "***** onDataChange");
                List<String> strings = new ArrayList<>();
                int index = 1;
                while (snapshot.hasChild("" + index)) {
                    Object value = snapshot.child("" + index).getValue();
                    if (value != null) {
                        strings.add(value.toString());
                    }
                    index++;
                }
                slideshowAdapter.addItems(strings);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    /*  public void flipperImages(int image) {
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(image);
    
            v_flipper.addView(imageView);
            v_flipper.setFlipInterval(4000);
            v_flipper.setAutoStart(true);
    
            v_flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
            v_flipper.setOutAnimation(getContext(), android.R.anim.slide_in_left);
    
        }
    */
    @Override
    public void onRefresh() {
        reff = FirebaseDatabase.getInstance().getReference().child("Bhav");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.v("TEST", "***** dataSnapshot : " + dataSnapshot);
                String bread = dataSnapshot.child("Bread").getValue().toString();
                String number = dataSnapshot.child("Number").getValue().toString();
                String silver = dataSnapshot.child("Silver").getValue().toString();
                String B = dataSnapshot.child("BREAD").getValue().toString();
                String N = dataSnapshot.child("NUMBER").getValue().toString();
                String S = dataSnapshot.child("SILVER").getValue().toString();
                String news = dataSnapshot.child("News").getValue().toString();
                String btmText = dataSnapshot.child("Message").getValue().toString();
                String heading = dataSnapshot.child("Update").getValue().toString();
                a.setText(bread);
                b.setText(number);
                c.setText(silver);
                e.setText(B);
                f.setText(N);
                g.setText(S);
                i.setText(news);
                j.setText(btmText);
                k.setText(heading);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
