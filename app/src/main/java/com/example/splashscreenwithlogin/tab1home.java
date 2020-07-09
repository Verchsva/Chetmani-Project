package com.example.splashscreenwithlogin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class tab1home<v_flipper> extends Fragment {
    ViewFlipper v_flipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab1home, container, false);
    }

    {

        int images[] = {R.drawable.banner,R.drawable.bannerr,R.drawable.bannerrrr};

        v_flipper = findViewById(R.id.slide_show);

        for (int i=0; i <images.length; i++){
            flipperImages(images[i]);
        }

        }

    private ViewFlipper findViewById(int slide_show) {
    }

    public void flipperImages(int image){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(image);

            v_flipper.addView(imageView);
            v_flipper.setFlipInterval(4000);
            v_flipper.setAutoStart(true);

            v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
            v_flipper.setOutAnimation(this,android.R.anim.slide_in_left);
        }

}
