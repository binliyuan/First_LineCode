package com.example.myapplication23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView textView;
    public myview myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myview=new myview(this);
    textView = findViewById(R.id.text);
        ActiviCollector.addActivit(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActiviCollector.removeActivity(this);
    }


}
