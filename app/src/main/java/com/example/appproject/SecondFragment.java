package com.example.appproject;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View second = inflater.inflate(R.layout.fragment_second, container, false);
        Button save = second.findViewById(R.id.button_second);

        //edit texts
        EditText activityName = (EditText)second.findViewById(R.id.activityNameInput);
        EditText textInput = (EditText)second.findViewById(R.id.TestInput);
        EditText thetime = (EditText)second.findViewById(R.id.editTextTime);
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String text = activityName.getText().toString();
                String desc = textInput.getText().toString();
                int t = Integer.parseInt(thetime.getText().toString());
                Global.activityNames.add(text);
                Global.descriptions.add(desc);
                Global.times.add(t);
                Global.paused.add(Boolean.FALSE);
                Global.counting.add(Boolean.FALSE);
                Global.pauseOffset.add((long)0);
                Chronometer showTime = null;
                Global.chronos.add(showTime);
                Global.savedTime.add(SystemClock.elapsedRealtime());
                Global.done.add(Boolean.FALSE);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        return second;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton back = view.findViewById(R.id.floatingActionButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

    }
}