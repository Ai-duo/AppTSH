package com.add.apptsh;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    Timer timer = new Timer();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG","服务启动");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(MainActivity.instance==null){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        },0,2*60*1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
