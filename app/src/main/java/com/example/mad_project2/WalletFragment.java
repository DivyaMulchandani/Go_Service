package com.example.mad_project2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class WalletFragment extends Fragment {

    View view;
    ImageButton plus_button,Scan,gift;
    RelativeLayout linear_wallet_2;
    Button card,upi;
    TextView some_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wallet, container, false);

        plus_button = view.findViewById(R.id.plus_button);
        linear_wallet_2 = view.findViewById(R.id.linear_wallet_2);
        card = view.findViewById(R.id.debit_and_c);
        upi = view.findViewById(R.id.upi);
        some_id = view.findViewById(R.id.some_id);
        Scan = view.findViewById(R.id.qr_button);
        gift = view.findViewById(R.id.gift_button);

        Bundle args = getArguments();
        if (args != null) {
            int receivedInt = args.getInt("int");
            // Now, you can use the received data in your fragment
            some_id.setText(receivedInt);
        }

        gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , ReferAndGetActivity.class);
                startActivity(intent);
            }
        });

        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.initiateScan();
            }
        });

        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_wallet_2.setVisibility(View.VISIBLE);
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog2();
            }
        });

        upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog1();
            }
        });


        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
        String scannedData = result.getContents();

        TextView textView = view.findViewById(R.id.result);
        textView.setText(scannedData);

        // Uncomment the next line if you want to display the result as a Toast
        // Toast.makeText(this, scannedData, Toast.LENGTH_LONG).show();
    }
    public static WalletFragment newInstance(int x) {
        WalletFragment fragment = new WalletFragment();
        Bundle args = new Bundle();
        args.putInt("int", x);
        fragment.setArguments(args);
        return fragment;
    }

    private void showDialog1() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_upi);

        Button pay= dialog.findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Payment Sucessfull",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
    private void showDialog2() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_cards);

        Button pay= dialog.findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Payment Sucessfull",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}
