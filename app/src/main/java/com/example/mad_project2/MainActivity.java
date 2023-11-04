package com.example.mad_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btn_new_acc ;
    EditText et_signin_email , et_signin_password;
    Button signin ;
    CheckBox showpass ;
    private FirebaseAuth UserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DatabaseReference dbr= FirebaseDatabase.getInstance().getReference();

        UserProfile = FirebaseAuth.getInstance();

        btn_new_acc = findViewById(R.id.btn_new_acc);
        et_signin_email = findViewById(R.id.et_signin_email);
        et_signin_password = findViewById(R.id.et_signin_password);
        signin = findViewById(R.id.btn_sign_in);

        showpass = findViewById(R.id.show_pass);

        btn_new_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,sign_up.class);
                startActivity(intent);
            }
        });

        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    et_signin_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    et_signin_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String S_et_signin_email = et_signin_email.getText().toString();
                String S_et_signin_password = et_signin_password.getText().toString();
                
                if (TextUtils.isEmpty(S_et_signin_email)){
                    Toast.makeText(MainActivity.this,"Entwer email !",Toast.LENGTH_LONG).show();
                    et_signin_email.setError("Enter Email");
                    et_signin_email.requestFocus();
                } else if (TextUtils.isEmpty(S_et_signin_password)) {
                    Toast.makeText(MainActivity.this,"Enter Password !",Toast.LENGTH_LONG).show();
                    et_signin_password.setError("Enter the password");
                    et_signin_password.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(S_et_signin_email).matches()) {
                    Toast.makeText(MainActivity.this,"Enter the Correct email",Toast.LENGTH_LONG).show();
                    et_signin_email.setError("Enter the Correct Mail!");
                    et_signin_email.requestFocus();
                } else {
                    loginUser(S_et_signin_email,S_et_signin_password);
                }
            }

            private void loginUser(String sEtSigninEmail, String sEtSigninPassword) {

                UserProfile.signInWithEmailAndPassword(sEtSigninEmail,sEtSigninPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Intent intent = new Intent(MainActivity.this,mainlayout.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "You are logged in", Toast.LENGTH_LONG).show();
                        }
                        else {
                            try {
                                throw task.getException();
                            }catch (FirebaseAuthInvalidUserException e){
                                et_signin_email.setError("User does not exists,Please register yourself");
                                et_signin_email.requestFocus();
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                et_signin_email.setError("Invalid credentials");
                                et_signin_email.requestFocus();
                            }catch (Exception e){
                                Log.e("loginexception",e.getMessage());
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                            }

                            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                        }

                    }
                });


            }
        });

    }

    //check if once the user has logged in if yess then directly open the home screen
    @Override
    protected void onStart() {
        super.onStart();
        if (UserProfile.getCurrentUser() != null){
            Toast.makeText(MainActivity.this,"Already logged In!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,HomeFragment.class);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this,"You need to log in",Toast.LENGTH_LONG).show();
        }
    }
}