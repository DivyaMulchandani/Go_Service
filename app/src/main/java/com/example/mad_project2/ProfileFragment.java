package com.example.mad_project2;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.play.core.integrity.p;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class ProfileFragment extends Fragment {

    Button previousBooking , myRatings , Address , Members , Work , helpInput , sign_out;
    ImageView profilePic;
    ImageButton profilebtn;
    int SELECT_PICTURE = 200;
    Uri selectedImageUri;
    TextView profileName,profileEmail;
    FirebaseAuth user;
    DatabaseReference userprofile;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        user = FirebaseAuth.getInstance();

        previousBooking = view.findViewById(R.id.previous_booking);
        myRatings = view.findViewById(R.id.my_ratings);
        Address = view.findViewById(R.id.address);
        Members = view.findViewById(R.id.members);
        Work = view.findViewById(R.id.work);
        helpInput = view.findViewById(R.id.help_input);

        sign_out = view.findViewById(R.id.btn_sign_out);

        profilePic = view.findViewById(R.id.ellipse);

        profilebtn = view.findViewById(R.id.ellipsebtn);

        profileName= view.findViewById(R.id.Olivia);
        profileEmail = view.findViewById(R.id.Oliviamail);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageChooser();

            }
        });

        //profileName and email
        if (user.getCurrentUser() != null){
           // String name = userprofile;
            String email = user.getCurrentUser().getEmail();
            profileName.setText(name);
            profileEmail.setText(email);
            Log.i("hi", "onCreateView: "+name);
        }else {

        }

        //signout
        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.signOut();
                Intent intent = new Intent(getActivity() , MainActivity.class);
                startActivity(intent);
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
                Intent intent = new Intent(getActivity() , MyRating.class);
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
                Intent intent = new Intent(getActivity() , WorkForUsActivity.class);
                startActivity(intent);
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
                Intent intent = new Intent(getActivity() , AddressActivity.class);
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