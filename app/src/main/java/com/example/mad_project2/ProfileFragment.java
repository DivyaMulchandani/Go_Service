package com.example.mad_project2;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.play.core.integrity.p;


public class ProfileFragment extends Fragment {

    TextView previousBooking , myRatings , Address , Members , Work , helpInput ;
    ImageView profilePic;
    ImageButton profilebtn;
    int SELECT_PICTURE = 200;
    Uri selectedImageUri;
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

        profilebtn = view.findViewById(R.id.ellipsebtn);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageChooser();

            }
        });

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
        return view;



    }

     void imageChooser() {


            // create an instance of the
            // intent of the type image
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);

            // pass the constant to compare it
            // with the returned requestCode
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    profilePic.setImageURI(selectedImageUri);
                }
            }
        }

    }
}