package com.chetmani.verchsva.HomePage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chetmani.verchsva.BuildConfig;
import com.chetmani.verchsva.R;
import com.chetmani.verchsva.Utils;
import com.chetmani.verchsva.bhawDetails.BhawDetailsAdapter;
import com.chetmani.verchsva.bhawDetails.BhawDetailsData;
import com.chetmani.verchsva.bhawDetails.SpacingItemDecorator;
import com.chetmani.verchsva.slideshow.SlideshowAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    Button share;
    ConstraintLayout constraintLayout;
    TextView news_feed,news_feed_1;

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

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        news_feed=root.findViewById(R.id.news_feed_1);

        TextView textView =root.findViewById(R.id.news_feed_1);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);

        news_feed_1=root.findViewById(R.id.news_feed_2);

        TextView textView1 =root.findViewById(R.id.news_feed_2);
        textView1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView1.setSelected(true);


        share=root.findViewById(R.id.btn_share);
        constraintLayout=root.findViewById(R.id.constraintLayout);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                share();
            }
        });

        return root;

    }

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
        BhawDetailsDatabaseReference();

    }

    private void share() {
        Bitmap bitmap=getBitmapFromView(constraintLayout);
        try {
            File file=new File(getContext().getExternalCacheDir(),"bhawdetails.jpg");
            FileOutputStream fout=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fout);
            fout.flush();
            fout.close();
            file.setReadable(true,false);

            final Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri photoUri= FileProvider.getUriForFile(getContext(), BuildConfig.APPLICATION_ID+".provider",file);
            intent.putExtra(Intent.EXTRA_STREAM, photoUri);
            intent.setType("image/png");

            startActivity(Intent.createChooser(intent,"share by"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ResourceAsColor")
    private Bitmap  getBitmapFromView(View view){
        Bitmap returnedBitmap=Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(returnedBitmap);
        Drawable bgDrawable=view.getBackground();
        if (bgDrawable != null){
            bgDrawable.draw(canvas);
        }
        else {
            canvas.drawColor(android.R.color.white);
        }
        view.draw(canvas);

        return returnedBitmap;
    }

    private void BhawDetailsDatabaseReference() {

        BhawDetailsAdapter bhawDetailsAdapter;
        RecyclerView rvBhawDetails = getView().findViewById(R.id.rv_bhaw_details);

        rvBhawDetails.setLayoutManager(new LinearLayoutManager(getContext()));



        FirebaseRecyclerOptions<BhawDetailsData> options =
                new FirebaseRecyclerOptions.Builder<BhawDetailsData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Bhaw"), BhawDetailsData.class)
                        .setLifecycleOwner(this)
                        .build();


        bhawDetailsAdapter = new BhawDetailsAdapter(options);
        rvBhawDetails.setAdapter(bhawDetailsAdapter);

        SpacingItemDecorator itemDecorator = new SpacingItemDecorator(10);
        rvBhawDetails.addItemDecoration(itemDecorator);


    }
}