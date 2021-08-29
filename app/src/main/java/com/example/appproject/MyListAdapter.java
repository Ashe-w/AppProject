package com.example.appproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;

import com.example.appproject.R;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> activity;
    private final ArrayList<String> description;
    private final ArrayList<Integer> time;
    private final ArrayList<Boolean> paused;
    private final ArrayList<Boolean> counting;
    public int b;
    public String a;
    public Color complete;


    public MyListAdapter(Activity context, ArrayList<String> activity,ArrayList<String> description, ArrayList<Integer> time,
                         ArrayList<Boolean> paused, ArrayList<Boolean> counting) {
        super(context, R.layout.mylist, activity);


        this.context=context;
        this.activity=activity;
        this.description=description;
        this.time=time;
        this.paused=paused;
        this.counting=counting;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        Button button = (Button) rowView.findViewById(R.id.button);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        Chronometer showTime = (Chronometer) rowView.findViewById(R.id.timer);
        TextView uTime = (TextView) rowView.findViewById(R.id.userTime);
        titleText.setText(activity.get(position));
        subtitleText.setText(description.get(position));
        b=Global.times.get(position);


        uTime.setText(toTimeString(b));

        showTime.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                Global.savedTime.set(position,chronometer.getBase());
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= Global.times.get(position)*1000*60) {
                    chronometer.stop();
                    button.setText("Done!");
                    button.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.buttonGreenB, null));
                    Toast.makeText(getContext(), activity.get(position)+" Finished!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        showTime.setBase(Global.savedTime.get(position));
        if(paused.get(position)==true){
            button.setText("Stop");
            showTime.start();
        }else{
            button.setText("Start");
            paused.set(position,false);
        }

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!button.getText().equals("Done!")) {
                    if (paused.get(position) == false) {
                        button.setText("Start");
                        paused.set(position, true);
                        Global.pauseOffset.set(position, SystemClock.elapsedRealtime() - showTime.getBase());
                        showTime.stop();

                    } else {
                        button.setText("Stop");
                        showTime.start();
                        showTime.setBase(SystemClock.elapsedRealtime() - Global.pauseOffset.get(position));
                        Global.savedTime.set(position, SystemClock.elapsedRealtime() - Global.pauseOffset.get(position));
                        paused.set(position, false);
                    }
                }
            }
        });

        return rowView;

    };
    public String toTimeString(int a){
        String c = Integer.toString(a/60);
        String b = Integer.toString(a%60);
        if (b.length()==1) b=" "+b;

        return ("/ "+c+":"+b+":00");
    }
}
