package com.example.myapplication21;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public Button button1;
    public Button button2;
    byte[] aByte;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        final ImageView imageView=findViewById(R.id.imageView);
        String s = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.d("aaa", "onCreate:+"+s);
        file=new File(Environment.getExternalStorageDirectory(),"/DCIM/Camera/IMG_20191128_160854.jpg");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fileInputStream=null;
                try {
                    fileInputStream=new FileInputStream(file);
                    Bitmap img =BitmapFactory.decodeStream(fileInputStream);


                    imageView.setImageBitmap(img);
                   // aByte=new byte[fileInputStream.available()];
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (fileInputStream!=null){
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }



                //imageView.setImageURI(Environment.getExternalStorageDirectory().toURI());

            }
        });

    }
}


