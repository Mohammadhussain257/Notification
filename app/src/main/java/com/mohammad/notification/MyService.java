package com.mohammad.notification;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    public Context context=this;
    public Handler handler=null;
    public Runnable runnable=null;

    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(context, "Service Created", Toast.LENGTH_SHORT).show();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                double randomNumber = getDoubleRandomNumber(1,100);
                Toast.makeText(context, "Random no"+randomNumber, Toast.LENGTH_SHORT).show();
            }
        };
        handler.postDelayed(runnable,2000);
    }

    private static double getDoubleRandomNumber(double min,double max){
        return (Math.random()*((min-max)+1))+min;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show();
    }
}
