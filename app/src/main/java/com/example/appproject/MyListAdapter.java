package com.example.appproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appproject.R;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> activity;
    private final ArrayList<String> description;
    private final ArrayList<Integer> time;

    public MyListAdapter(Activity context, ArrayList<String> activity,ArrayList<String> description, ArrayList<Integer> time) {
        super(context, R.layout.mylist, activity);


        this.context=context;
        this.activity=activity;
        this.description=description;
        this.time=time;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        Button button = (Button) rowView.findViewById(R.id.button);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(activity.get(position));
        button.setText(time.get(position).toString());
        subtitleText.setText(description.get(position));

        return rowView;

    };
}
