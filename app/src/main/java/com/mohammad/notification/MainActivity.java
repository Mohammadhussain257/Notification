package com.mohammad.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    Button btnNotificatoin1,btnNotification2;

    BroadCastReceiver broadCastReceiver = new BroadCastReceiver();

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadCastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadCastReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        this.btnNotificatoin1=findViewById(R.id.btnNotification1);
        this.btnNotification2=findViewById(R.id.btnNotification2);

        this.btnNotificatoin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotificationOne();
            }
        });

        this.btnNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotificationTwo();
            }
        });
    }

    private void displayNotificationOne(){
        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_notifications_active)
                .setContentTitle("Notification One")
                .setContentText("Notificaton One Content")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);
    }
    private void displayNotificationTwo(){
        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_notifications_none)
                .setContentTitle("Notification One")
                .setContentText("Notificaton One Content")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);
    }
}
