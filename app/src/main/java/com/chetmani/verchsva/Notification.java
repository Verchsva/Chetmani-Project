package com.chetmani.verchsva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Notification extends AppCompatActivity {

    private static final String CHANNEL_ID = "chetmani_notification";
    private static final String CHANNEL_NAME = "Chetmani Notification";
    private static final String CHANNEL_DESC = "Chetmani Jewellers Notifications";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        if (Build.VERSION.SDK_INT  >= Build.VERSION_CODES.O){

            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }

    private void displayNotification() {

        NotificationCompat.Builder mBuilder=
                new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.logo_finaaaaal)
                .setContentTitle("Hello From Chetmani")
                .setContentText("First Notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
        mNotificationMgr.notify(1,mBuilder.build());
    }

}