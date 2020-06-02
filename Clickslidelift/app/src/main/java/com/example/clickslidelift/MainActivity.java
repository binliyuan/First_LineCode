package com.example.clickslidelift;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SimpleDateFormat s_format = new SimpleDateFormat("hh时mm分ss秒");
    private Button btn;
    private TextView textView;
    boolean j=true;
    String b="";
    String a="";
    String c="";
    String d="";

    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;
    public static final String TAG = "MainActivity" ;
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    FruitAdapter adapter;
    ListView listView;
    long startTime; // 获取开始时间
    long MiddleTime;
    long HoverTime;
    // doThing(); // 测试的代码段
    long endTime; // 获取结束时间


    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Log.i(TAG, "handleMessage: "+msg.arg1);
                    a=String.valueOf(msg.arg1);
                    break;
                case 2:
                    b=s_format.format(new Date())+":"+"点击"+(startTime-MiddleTime)+"Millisecond"+"\n";
                    b+=s_format.format(new Date())+":"+"移动"+(MiddleTime-endTime)+"Millisecond"+"\n";
                   // b+=s_format.format(new Date())+":"+"悬停"+(HoverTime-endTime)+"Millisecond"+"\n";
                    textView.setText(b);
                    Fruit fruit = new Fruit(b);
                    fruitList.add(fruit);
                    listView.setAdapter(adapter);
                    Log.i(TAG+"2", "handleMessage11111111111111: "+HoverTime);
                    Log.i(TAG+"2", "handleMessage11111111111111: "+MiddleTime);
                    j=false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =  findViewById(R.id.btn);
        textView=findViewById(R.id.text);

        listView = (ListView) findViewById(R.id.list_view);
        adapter= new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        //监听
        btn.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /*x1 = event.getX();
                y1 = event.getY();*/
                /*x2 = event.getX();
                y2 = event.getY();*/
//                c= event.getX().To
//                final Message message1=new Message();
//                message1.what=2;
//                message1.arg1=1;
//
//                message1.obj=new String();
//               // Log.e("1aaaaaaaaa", "代码运行时间： " + (endTime - startTime) + "ms");
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        handler.sendMessage(message1);
//                    }
//                },0);
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.i("1a","aaaaaa");
                    MyThread thread = new MyThread();
                    j=true;
                    thread.start();
                    startTime= System.currentTimeMillis();

                    /*Toast.makeText(MainActivity.this,"按下了" ,Toast.LENGTH_SHORT).show();
                    btn.setBackgroundColor(Color.RED);*/
                }
                else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    MiddleTime= System.currentTimeMillis();
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    endTime= System.currentTimeMillis();

                    //textView.setText("松开了");
                    /*Toast.makeText(MainActivity.this,"松开了" ,Toast.LENGTH_SHORT).show();
                    btn.setBackgroundColor(Color.BLUE);*/
                }

                return false;

            }
        });

    }
    public class MyThread extends Thread {

        //继承Thread类，并改写其run方法
        private final static String TAG = "My Thread ===> ";


        public void run(){
            Log.d(TAG, "run");
            int i=0;
            while (j)
            {
                i++;

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
                    Thread.sleep(1);
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
                },0);
            }
        }
    }
}
