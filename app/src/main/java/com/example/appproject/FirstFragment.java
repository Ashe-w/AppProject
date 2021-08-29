package com.example.appproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FirstFragment extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View firstLayOut = inflater.inflate(R.layout.fragment_first, container, false);
        ListView listView=firstLayOut.findViewById(R.id.listview);



        ArrayAdapter adapter1=new ArrayAdapter(firstLayOut.getContext(),android.R.layout.simple_list_item_1,Global.activityNames);
        MyListAdapter adapter=new MyListAdapter(this.getActivity(), Global.activityNames, Global.descriptions,Global.times,Global.counting,Global.paused);
        listView.setAdapter(adapter);


        return firstLayOut;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button b2 = view.findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}