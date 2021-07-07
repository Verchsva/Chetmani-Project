package com.chetmani.verchsva.HomePage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chetmani.verchsva.R;
import com.chetmani.verchsva.Utils;
import com.chetmani.verchsva.gallery.GalleryAdapter;
import com.chetmani.verchsva.gallery.GalleryData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter galleryAdapter;
    RecyclerView.LayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        recyclerView=getView().findViewById(R.id.rv_gallery);
//        recyclerView.setHasFixedSize(true);
//        layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,true);
//        recyclerView.setLayoutManager(layoutManager);
//        galleryAdapter=new GalleryAdapter(getContext(),galleryImages);
//        recyclerView.setAdapter(galleryAdapter);
        RecyclerView recyclerView=getView().findViewById(R.id.rv_gallery);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        GalleryData[] galleryData= new GalleryData[]{
            new GalleryData(R.drawable.bannerrrr),
                new GalleryData(R.drawable.bannerr),
                new GalleryData(R.drawable.banner),
                new GalleryData(R.drawable.bannerrrrrr),

        };

        GalleryAdapter galleryAdapter= new GalleryAdapter(galleryData,GalleryFragment.this);
        recyclerView.setAdapter(galleryAdapter);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//       final View root= inflater.inflate(R.layout.fragment_gallery, container, false);
//        recyclerView=root.findViewById(R.id.rv_gallery);
//        recyclerView.setHasFixedSize(true);
//        layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,true);
//        recyclerView.setLayoutManager(layoutManager);
//        galleryAdapter=new GalleryAdapter(GalleryData[],GalleryFragment.this);
//        recyclerView.setAdapter(galleryAdapter);
       return inflater.inflate(R.layout.fragment_gallery, container, false); }


       @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView rvImages = getView().findViewById(R.id.rv_images);
        rvImages.setLayoutManager(new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false));
        final GalleryAdapter galleryAdapter = new GalleryAdapter();
        rvImages.setAdapter(galleryAdapter);

        DatabaseReference databaseReference = Utils.getInstance().getReference().child("IMAGES");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> strings = new ArrayList<>();
                int index = 1;
                while (snapshot.hasChild("" + index)) {
                    Object value = snapshot.child("" + index).getValue();
                    if (value != null) {
                        strings.add(value.toString());
                    }
                    index++;
                }
                galleryAdapter.addItems(strings);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }