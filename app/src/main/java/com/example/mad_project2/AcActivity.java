package com.example.mad_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class AcActivity extends AppCompatActivity {

    Button btadd1, btadd2, btadd3, btadd4;
    TextView txt1, txt2, txt3, txt4, txt;
    Integer a1, a2,a3,a4,res=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac);

        btadd1 = findViewById(R.id.add_btn_ac1);
        btadd2 = findViewById(R.id.add_btn_ac2);
        btadd3 = findViewById(R.id.add_btn_ac3);
        btadd4 = findViewById(R.id.add_btn_ac4);

        txt1 = findViewById(R.id.price_rate1);
        txt2 = findViewById(R.id.price_rate2);
        txt3 = findViewById(R.id.price_rate3);
        txt4 = findViewById(R.id.price_rate4);

        txt = findViewById(R.id.total_1);

        String str1=txt1.getText().toString();
        a1=Integer.parseInt(str1);
        String str2=txt2.getText().toString();
        a2=Integer.parseInt(str2);
        String str3=txt3.getText().toString();
        a3=Integer.parseInt(str3);
        String str4=txt4.getText().toString();
        a4=Integer.parseInt(str4);

        btadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a1;
                txt.setText(res.toString());
            }
        });

        btadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a2;
                txt.setText(res.toString());
            }
        });

        btadd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a2;
                txt.setText(res.toString());
            }
        });

        btadd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a2;
                txt.setText(res.toString());
            }
        });

    }
}