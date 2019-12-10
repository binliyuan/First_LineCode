package com.example.myapplication_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private static MainActivity a;
    private UpdateHandler handler;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        handler = new UpdateHandler(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100 || isFinishing()) {
                    count++;
                    Message msg = handler.obtainMessage();
                    msg.obj = String.valueOf(count);
                    handler.sendMessage(msg);
                    SystemClock.sleep(1000);
                }
            }
        }).start();
    }
    private static class UpdateHandler extends Handler {
        private WeakReference<MainActivity> reference;
        public UpdateHandler(MainActivity activity) {
            this.reference = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (reference != null && (a=reference.get()) != null){
                MainActivity  mainActivity = a;
                mainActivity.textView.setText(String.valueOf(msg.obj));
            }
        }
    }
}
