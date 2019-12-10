package com.example.myapplication17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.myapplication17.broadcast1");
                intent.setComponent(new ComponentName("com.example.myapplication17","com.example.myapplication17.MyReceiver"));
                intent.putExtra("name","aaaa");
                sendBroadcast(intent,null);
            }
        });
    }
  /*  public void startBroadcast(View view){
                //开启广播
                //创建一个意图对象
                Intent intent = new Intent();
                 //指定发送广播的频道
                 intent.setAction("com.example.BROADCAST");
                //发送广播的数据
                intent.putExtra("key", "发送无序广播,顺便传递的数据");
                //发送
                sendBroadcast(intent);
             }*/
}
