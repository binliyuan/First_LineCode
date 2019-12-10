package com.example.myapplication11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public TextView textView;
    public Button button;
    public static final String TAG = "MainActivity" ;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        Log.i(TAG, "handleMessage: "+msg.arg1);
                        textView.setText(String.valueOf(msg.arg1));
                        break;
                }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text1);
        button=findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyThread thread =new MyThread();
                thread.start();
            }
        });
    }
    public class MyThread extends Thread {

        //继承Thread类，并改写其run方法
        private final static String TAG = "My Thread ===> ";
        public void run(){
            Log.d(TAG, "run");

            for(int i = 0; i<100; i++)
            {

                /*try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int finalI = i;
                runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText(String.valueOf(finalI));
                }
            });*/
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final Message message=new Message();
                message.what=1;
                message.arg1=i;
                Log.e("1a", String.valueOf(message.arg1));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendMessage(message);
                    }
                },1000);
            }
        }
    }
}
