package com.example.mad_project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class OrderFragment extends Fragment {

    View view ;
    Button min1,min2,min3,pay;

    RelativeLayout rl1,rl2,rl3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order, container, false);
        min1 = view.findViewById(R.id.min1);
        min2 = view.findViewById(R.id.min2);
        min3 = view.findViewById(R.id.min3);

        pay = view.findViewById(R.id.btn_pay_1);

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


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new fragment and transaction
                Fragment newFragment = new WalletFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.frame_layout, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });
        return view;
    }
}