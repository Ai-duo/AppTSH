package com.add.apptsh;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

import androidx.annotation.NonNull;


public class MyApp extends Application {
    Thread.UncaughtExceptionHandler handler;

    @Override
    public void onCreate() {
        super.onCreate();

        handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
                restart();
                android.os.Process.killProcess(Process.myPid());
                System.exit(1);
            }
        };
       // Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    public void restart() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
