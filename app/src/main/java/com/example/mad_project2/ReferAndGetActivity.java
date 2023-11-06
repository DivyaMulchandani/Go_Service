package com.example.mad_project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReferAndGetActivity extends AppCompatActivity {

    Button redeem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_and_get2);

        redeem = findViewById(R.id.redeem_btn);
        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int x = 9999;
//                Intent intent = new Intent(ReferAndGetActivity.this, mainlayout.class);
//                intent.putExtra("int", x);
//                startActivity(intent);
                Toast.makeText(ReferAndGetActivity.this,"Enter Correct Code",Toast.LENGTH_LONG).show();
            }
        });
    }
}