package com.example.myapplication14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService = (Button) findViewById(R.id.start_service);
        Button stopService = (Button) findViewById(R.id.stop_service);
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.start_service:
                        Intent startIntent = new Intent(MainActivity.this, MyService.class);
                        startService(startIntent);//启动服务
                        break;
                    case R.id.stop_service:
                        Intent stopIntent = new Intent(MainActivity.this,MyService.class);
                        stopService(stopIntent);//停止服务
                        break;
                    default:
                        break;
                }
            }
        });
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.start_service:
                        Intent startIntent = new Intent(MainActivity.this, MyService.class);
                        startService(startIntent);//启动服务
                        break;
                    case R.id.stop_service:
                        Intent stopIntent = new Intent(MainActivity.this, MyService.class);
                        stopService(stopIntent);//停止服务
                        break;
                    default:

                }
            }
        });






    }
}
