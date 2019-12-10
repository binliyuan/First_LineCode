package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class myActivity extends AppCompatActivity {
    private YView yview;
  //  public int i;
    private int mTextColor_int[]={Color.rgb(255,0,0),Color.rgb(255,165,0),
            Color.rgb(255,255,0),Color.rgb(0,255,0),Color.rgb(0,127,255),
            Color.rgb(0,0,255),Color.rgb(139,0,255)};
    private int mTextColorint[]={Color.BLUE,Color.GREEN,Color.RED};
//    private UpdateHandler handler;
    private int count = 0;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                        yview.setmTextBg(mTextColor_int[msg.arg1]);
                        yview.postInvalidate();
                        break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        yview=findViewById(R.id.yv1);
        yview.setOnClickListener(new myActivity.MyClick());
//        handler = new UpdateHandler(this);
        Log.e("bin","122");

    }

    public class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            yview.setmText("11111111");
            MyThread thread = new MyThread();
            thread.start();


            Log.e("bin",yview.getmText());
            /*new Thread(new Runnable() {

                @Override
                public void run() {

                    while (count < 100 || isFinishing()) {
                        count++;
                        Log.e("bin","112");
                        if(count<2) {
                            Message msg = handler.obtainMessage();
                            Log.e("binliyuan",String.valueOf(mTextColorint[count]));
                            msg.obj = String.valueOf(mTextColorint[count]);
                            handler.sendMessage(msg);
                            SystemClock.sleep(1000);
                        }
                        else
                        {
                            count=0;
                        }
                    }
                }
            }).start();
*/
        }
    }
    public class MyThread extends Thread {

        //继承Thread类，并改写其run方法
        private final static String TAG = "My Thread ===> ";

        public void run() {
            Log.d(TAG, "run");
            while (true) {
                for (int i = 0; i < mTextColor_int.length; i++) {

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
                    final Message message = new Message();
                    message.what = 1;
                    message.arg1 = i;
                    Log.e("1a", String.valueOf(message.arg1));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            handler.sendMessage(message);
                        }
                    }, 1000);
                }
            }
        }
    }
   /* private static class UpdateHandler extends Handler {
        private WeakReference<myActivity> reference;


        public UpdateHandler(myActivity activity) {
            this.reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (reference != null && reference.get() != null){
                myActivity activity  = reference.get();
                Log.e("bin",String.valueOf(msg.obj));
                activity.yview.setmTextBg(Integer.parseInt(String.valueOf(msg.obj)));
            }
        }
    }*/
}
