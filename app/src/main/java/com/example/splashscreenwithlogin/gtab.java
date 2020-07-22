package com.example.splashscreenwithlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class gtab extends Fragment {
     GridView gridView;


    @Override
    public View onCreateView(
            final LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab2home, container, false);

        gridView=(GridView) root.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getContext(),FullImageActivity.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });
        return root;
    }


}
