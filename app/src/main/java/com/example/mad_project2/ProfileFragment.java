package com.example.mad_project2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.play.core.integrity.p;


public class ProfileFragment extends Fragment {

    TextView previousBooking , myRatings , Address , Members , Work , helpInput ;
    ImageView profilePic;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        previousBooking = view.findViewById(R.id.previous_booking);
        myRatings = view.findViewById(R.id.my_ratings);
        Address = view.findViewById(R.id.address);
        Members = view.findViewById(R.id.members);
        Work = view.findViewById(R.id.work);
        helpInput = view.findViewById(R.id.help_input);

        profilePic = view.findViewById(R.id.ellipse);

        previousBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , previousBookingActivity.class);
                startActivity(intent);
            }
        });

        myRatings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , myRatingActivity.class);
                startActivity(intent);
            }
        });

        Members.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , MembershipActivity.class);
                startActivity(intent);
            }
        });

        Work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity() , MembershipActivity.class);
//                startActivity(intent);
            }
        });

        helpInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity() , MembershipActivity.class);
//                startActivity(intent);
            }
        });



        Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , previousBookingActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);



    }
}