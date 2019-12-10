package com.example.myapplication;

import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView textView;
    boolean j=true;
    String a="";
    public static final String TAG = "MainActivity" ;
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    String[] data={"1","2"};
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
                   // textView.setText("now time"+a+"Millisecond");
                    Log.i(TAG, "handleMessage11111111111111: "+msg.arg1);
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
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Fruit fruit = fruitList.get(position);
//                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
        //监听
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.i("1a","aaaaaa");
                    MyThread thread = new MyThread();
                    j=true;
                    thread.start();
                    /*Toast.makeText(MainActivity.this,"按下了" ,Toast.LENGTH_SHORT).show();
                    btn.setBackgroundColor(Color.RED);*/
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    final Message message1=new Message();
                    message1.what=2;
                    message1.arg1=1;
                    Log.e("1a", String.valueOf(message1.arg1));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            handler.sendMessage(message1);
                        }
                    },0);
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
    private void initFruits() {
        for (int i = 0; i < 1; i++) {
            Fruit apple = new Fruit("Apple");
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana");
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange");
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon");
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear");
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape");
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple");
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry");
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry");
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango");
            fruitList.add(mango);
        }
    }

}
