package com.example.myapplication16;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    public class MyBind extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Toast.makeText(this, "Service Started1", Toast.LENGTH_LONG).show();
        intent.putExtra("name","111111111");
        return new MyBind();
     //   throw new UnsupportedOperationException("Not yet implemented");

    }
    public String abc()
    {
        String a="aaa";
        return a;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started1", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
