package com.example.mad_project2;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;


public class ProfileFragment extends Fragment {

    Button previousBooking , myRatings , Address , Members , Work , helpInput , sign_out;
    ImageView profilePic;
    ImageButton profilebtn;
    int SELECT_PICTURE = 200;
    Uri selectedImageUri;
    TextView profileName,profileEmail;
    FirebaseAuth user;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
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
            userprofile= database.getReference("//Registered User: /osyXlltSKKUvaqM906bQnEFYE502/firebase/Name");
            //profile.child(firebaseUser.getUid()).setValue(user)
//            String name = userprofile.child(firebaseUser.getUid()).getKey();

            String name =userprofile.toString();
            String email = user.getCurrentUser().getEmail();
            //profileName.setText(name);
            profileEmail.setText(email);
            //Log.i("hi", "onCreateView: "+name);
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
                // Create new fragment and transaction
                Fragment newFragment = new MembershipFragment();
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
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://www.google.com/"));
                startActivity(viewIntent);
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