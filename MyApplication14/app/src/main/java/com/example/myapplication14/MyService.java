package com.example.myapplication14;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class MyService extends Service {
    private String path = "http://na01.sycdn.kuwo.cn/2aa3e1e674362cb7cba2fe5f7f31353a/5ddb9740/resource/n2/21/78/1715585164.mp3";
    private MediaPlayer player;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //这里只执行一次，用于准备播放器
        /*player = new MediaPlayer();
        try {
            player.setDataSource(path);
            //准备资源
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("服务", "准备播放音乐");*/

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed");
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Started1", Toast.LENGTH_LONG).show();

        Log.d("MyService","onDestroy executed");
    }

}
