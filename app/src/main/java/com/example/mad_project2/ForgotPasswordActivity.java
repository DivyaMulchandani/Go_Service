package com.example.mad_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button btnReset, btnBack;
    EditText edtEmail;
    String strEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnBack = findViewById(R.id.btnForgotPasswordBack);
        btnReset = findViewById(R.id.btnReset);
        edtEmail = findViewById(R.id.edtForgotPasswordEmail);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = edtEmail.getText().toString().trim();
                if (!TextUtils.isEmpty(strEmail)) {
                    ResetPassword();
                } else {
                    edtEmail.setError("Email field can't be empty");
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void ResetPassword() {
        btnReset.setVisibility(View.INVISIBLE);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ForgotPasswordActivity.this, "Reset Password link has been sent to your registered Email", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}