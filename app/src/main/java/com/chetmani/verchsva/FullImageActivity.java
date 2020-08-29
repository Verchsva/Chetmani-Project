package com.chetmani.verchsva;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class FullImageActivity extends AppCompatActivity {

    private static final String EXTRA_IMAGE_URL = "EXTRA_IMAGE_URL";

    public static Intent getStartIntent(Context context, String imageUrl) {
        Intent intent = new Intent(context, FullImageActivity.class);
        intent.putExtra(EXTRA_IMAGE_URL, imageUrl);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        Picasso.get().load(imageUrl).into(imageView);
    }
}
