package com.example.appproject;

import android.widget.Chronometer;

import java.util.ArrayList;

public class Global {
    public static ArrayList<String> activityNames =new ArrayList<>();
    public static ArrayList<String> descriptions = new ArrayList<>();
    public static ArrayList<Integer> times = new ArrayList<>();
    public static ArrayList<Boolean> counting = new ArrayList<>();
    public static ArrayList<Boolean> paused = new ArrayList<>();
    public static ArrayList<Long> pauseOffset = new ArrayList<>();
    public static ArrayList<Chronometer> chronos = new ArrayList<>();
    public static ArrayList<Long> savedTime = new ArrayList<>();
    public static ArrayList<Boolean> done =  new ArrayList<>();
}