package com.mohammad.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyservicesActivity extends AppCompatActivity {

    Button btnStartService,btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myservices);
        this.btnStartService=findViewById(R.id.btnStartService);
        this.btnStopService=findViewById(R.id.btnStopService);

        this.btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();

            }
        });

        this.btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
    }

    private void startService(){
        startService(new Intent(this,MyService.class));
    }

    private void stopService(){
        stopService(new Intent(this,MyService.class));
    }
}
