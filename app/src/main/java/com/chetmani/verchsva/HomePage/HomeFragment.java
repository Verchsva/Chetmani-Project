package com.chetmani.verchsva.HomePage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chetmani.verchsva.R;
import com.chetmani.verchsva.Utils;
import com.chetmani.verchsva.slideshow.SlideshowAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    TextView  news_feed;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        dataForImageSliders=new ArrayList<>();
//        setData();
//        setAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

//    private void setAdapter() {
//        recyclerView=getView().findViewById(R.id.recyclerSlider);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,true));
//        sliderAdapter=new ImageSliderAdapter(getContext(),dataForImageSliders);
//        recyclerView.setAdapter(sliderAdapter);
//
//        final int interval_time=3000;
//        Handler handler=new Handler();
//        Runnable runnable=new Runnable() {
//            int count=0;
//            @Override
//            public void run() {
//                if (count<dataForImageSliders.size()){
//                    recyclerView.scrollToPosition(interval_time);
//                    if (count==dataForImageSliders.size()){
//                        count=0;
//                    }
//                }
//            }
//        };
//        handler.postDelayed(runnable,interval_time);
//    }
//
//    private void setData() {
//        dataForImageSliders.add(new DataForImageSlider("R.drawable.bannerrrrrrr","1"));
//        dataForImageSliders.add(new DataForImageSlider("R.drawable.bannerrrrrrr","2"));
//        dataForImageSliders.add(new DataForImageSlider("R.drawable.bannerrrrrrr","3"));
//        dataForImageSliders.add(new DataForImageSlider("R.drawable.bannerrrrrrr","4"));
//    }
//}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


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
}