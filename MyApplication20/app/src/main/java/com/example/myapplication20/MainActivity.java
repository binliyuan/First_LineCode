package com.example.myapplication20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Stetho.initializeWithDefaults(this);
        final EditText editText=findViewById(R.id.editText1);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        file=new File(Environment.getExternalStorageDirectory(),"text.txt");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream=null;
                String text=editText.getText().toString();
                Log.d(text, "onClick:111 ");
                try {
                 //   fileOutputStream=openFileOutput("memo",MODE_PRIVATE);内部
                    fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(text.getBytes());
                    fileOutputStream.flush();
                    Log.d(text, "onClick:111 ");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(fileOutputStream!=null)
                            fileOutputStream.close();
                            Log.d(text, "onClick:111111 ");
                        Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
