package com.example.splashscreenwithlogin;

import android.os.Bundle;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ftab extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
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
//        TextView textView = root.findViewById(R.id.news_feed);
//        textView.setSelected(true);

        a = (TextView) root.findViewById(R.id.tableId2);
        b = (TextView) root.findViewById(R.id.tableId4);
        c = (TextView) root.findViewById(R.id.tableId6);
        d = (TextView) root.findViewById(R.id.tableId8);
        e = (TextView) root.findViewById(R.id.tableHeading1);
        f = (TextView) root.findViewById(R.id.tableHeading3);
        g = (TextView) root.findViewById(R.id.tableHeading5);
        h = (TextView) root.findViewById(R.id.tableHeading9);
        i = (TextView) root.findViewById(R.id.news_feed);
//        i.setSelected(true);
        j = (TextView) root.findViewById(R.id.btmText);

        refreshLayout = root.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this);


        int images[] = {R.drawable.banner, R.drawable.bannerr, R.drawable.bannerrrr};
        v_flipper = root.findViewById(R.id.v_flipper);

        for (int i = 0; i < images.length; i++) {
            flipperImages(images[i]);
        }
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onRefresh();
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getContext(), android.R.anim.slide_in_left);

    }

    @Override
    public void onRefresh() {
        reff = FirebaseDatabase.getInstance().getReference().child("Bhav");//.child("1");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.v("TEST", "***** dataSnapshot : " + dataSnapshot);
                String bread = dataSnapshot.child("Bread").getValue().toString();
                String number = dataSnapshot.child("Number").getValue().toString();
                String silver = dataSnapshot.child("Silver").getValue().toString();
                String rtgs = dataSnapshot.child("RTGS").getValue().toString();
                String B = dataSnapshot.child("BREAD").getValue().toString();
                String N = dataSnapshot.child("NUMBER").getValue().toString();
                String S = dataSnapshot.child("SILVER").getValue().toString();
                String R = dataSnapshot.child("GOLDRTGS").getValue().toString();
                String news = dataSnapshot.child("News").getValue().toString();
                String btmText = dataSnapshot.child("Message").getValue().toString();
                a.setText(bread);
                b.setText(number);
                c.setText(silver);
                d.setText(rtgs);
                e.setText(B);
                f.setText(N);
                g.setText(S);
                h.setText(R);
//                i.setText(news);
                j.setText(btmText);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
