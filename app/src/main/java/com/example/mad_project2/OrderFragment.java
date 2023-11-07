package com.example.mad_project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class OrderFragment extends Fragment {

    View view ;
    Button min1,min2,min3;
    RelativeLayout rl1,rl2,rl3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order, container, false);
        min1 = view.findViewById(R.id.min1);
        min2 = view.findViewById(R.id.min2);
        min3 = view.findViewById(R.id.min3);

        rl1 = view.findViewById(R.id.Rl1);
        rl2 = view.findViewById(R.id.Rl2);
        rl3 = view.findViewById(R.id.Rl3);


        min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl1.setVisibility(view.INVISIBLE);
            }
        });
        min2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl2.setVisibility(view.INVISIBLE);
            }
        });
        min3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl3.setVisibility(view.INVISIBLE);
            }
        });
        return view;
    }
}