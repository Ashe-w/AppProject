package com.example.appproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {
    TextView countTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View firstLayOut=inflater.inflate(R.layout.fragment_first, container, false);
        countTextView = firstLayOut.findViewById(R.id.D);
        // Inflate the layout for this fragment
        return firstLayOut;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        //buttonA
        view.findViewById(R.id.A).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast toastA = Toast.makeText(getActivity(),"show toast A",Toast.LENGTH_SHORT);
                toastA.show();
            }
        });
        view.findViewById(R.id.B).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCount(v);
            }
        });
        view.findViewById(R.id.C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum(v);
            }
        });
    }
    public void addCount(View view){

        String textD = countTextView.getText().toString();
        Integer count=Integer.parseInt(textD);
        count++;
        countTextView.setText(count.toString());
    }
    public void randomNum(View view){
        Integer number = (int)(Math.random()*100);
        countTextView.setText(number.toString());
    }
}