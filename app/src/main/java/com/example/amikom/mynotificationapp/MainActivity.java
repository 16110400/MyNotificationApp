package com.example.amikom.mynotificationapp;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import static com.example.amikom.mynotificationapp.NotificationUtils.ANDROID_CHANNEL_ID;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {

    public  static final int NOTIF_ID = 1;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:amikom.ac.id"));
        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Button btn = (Button) findViewById(R.id.buttonNotif);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    showNotifOreo();
                else showNotifDefault();
            }
        });
    }

        private void showNotifDefault() {
                   NotificationCompat.Builder notifBuilder = (NotificationCompat.Builder) new
                NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.outline_card_travel_24)
                .setLargeIcon(BitmapFactory.decodeResource(getResources()
                        , R.drawable.outline_card_travel_24))
                .setContentTitle(getResources().getString(R.string.content_title))
                .setContentText(getResources().getString(R.string.content_text))
                .setSubText(getResources().getString(R.string.subtext))
                .setAutoCancel(true);
                   NotificationManagerCompat ncm = NotificationManagerCompat.from(getApplicationContext());
                     ncm.notify(NOTIF_ID, notifBuilder.build());
            }

                private void showNotifOreo(){
            Notification.Builder notifBuilder = new Notification.Builder(MainActivity.this, ANDROID_CHANNEL_ID)
                    .setSmallIcon(R.drawable.outline_card_travel_24)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources()
                            , R.drawable.outline_card_travel_24))
                    .setContentTitle(getResources().getString(R.string.content_title))
                    .setContentText(getResources().getString(R.string.content_text))
                    .setSubText(getResources().getString(R.string.subtext))
                    .setAutoCancel(true);

            NotificationUtils utils = new NotificationUtils (MainActivity.this);
        }







}
