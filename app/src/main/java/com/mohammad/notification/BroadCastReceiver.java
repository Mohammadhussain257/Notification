package com.mohammad.notification;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BroadCastReceiver extends android.content.BroadcastReceiver {
    private NotificationManagerCompat notificationManagerCompat;
    boolean noConnectivity;
    
    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManagerCompat=NotificationManagerCompat.from(context);
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
            );
            if (noConnectivity){
                Notification notification = new NotificationCompat.Builder(context,CreateChannel.CHANNEL_1)
                        .setSmallIcon(R.drawable.ic_notifications_active)
                        .setContentTitle("Disconnect")
                        .setContentText("No Connectivity found")
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                notificationManagerCompat.notify(11,notification);
            }else {

                Notification notification = new NotificationCompat.Builder(context,CreateChannel.CHANNEL_1)
                        .setSmallIcon(R.drawable.ic_notifications_active)
                        .setContentTitle("Connected")
                        .setContentText("Connection Successfully Established")
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                notificationManagerCompat.notify(22,notification);
            }
        }
    }
}
