package com.chetmani.verchsva;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    Button sendEnquiry;

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

        relativeLayout=findViewById(R.id.relative_layout);
        sendEnquiry=findViewById(R.id.btn_send_enquiry);
        sendEnquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEnquiry();
            }
        });

    }

    private void sendEnquiry() {
        Bitmap bitmap=getBitmapFromView(relativeLayout);
        try {
            File file=new File(this.getExternalCacheDir(),"fullimage.jpg");
            FileOutputStream fout=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fout);
            fout.flush();
            fout.close();
            file.setReadable(true,false);

            final Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri photoUri= FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID+".provider",file);
            intent.putExtra(Intent.EXTRA_STREAM, photoUri);
            intent.setType("image/png");

            startActivity(Intent.createChooser(intent,"send enquiry"));

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
}
