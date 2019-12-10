package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView;
        Intent intent =getIntent();
        Bundle bundle =intent.getExtras();
        textView=findViewById(R.id.text1);
        textView.setText(bundle.getString("name"));

    }
}
