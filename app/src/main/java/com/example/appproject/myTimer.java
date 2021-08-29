package com.example.appproject;
import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

public abstract class myTimer extends CountDownTimer  {
    public myTimer (long millisInFuture,
                           long countDownInterval){
        super(millisInFuture, countDownInterval);
    }
    public void onPause(){

    }
}
