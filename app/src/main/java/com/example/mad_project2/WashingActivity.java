package com.example.mad_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WashingActivity extends AppCompatActivity {

    Button btadd1, btadd2, btadd3;
    TextView txt1, txt2, txt3, txt;
    Integer a1, a2,a3,res=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washing);

        btadd1 = findViewById(R.id.add_btn_wm1);
        btadd2 = findViewById(R.id.add_btn_wm2);
        btadd3 = findViewById(R.id.add_btn_wm3);

        txt1 = findViewById(R.id.price_rate_wm1);
        txt2 = findViewById(R.id.price_rate_wm2);
        txt3 = findViewById(R.id.price_rate_wm3);

        txt = findViewById(R.id.total_3);

        String str1=txt1.getText().toString();
        a1=Integer.parseInt(str1);
        String str2=txt2.getText().toString();
        a2=Integer.parseInt(str2);
        String str3=txt3.getText().toString();
        a3=Integer.parseInt(str3);


        btadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a1;
                txt.setText(res.toString());
                btadd1.setVisibility(View.INVISIBLE);
            }
        });

        btadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a2;
                txt.setText(res.toString());
                btadd2.setVisibility(View.INVISIBLE);
            }
        });

        btadd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a2;
                txt.setText(res.toString());
                btadd3.setVisibility(View.INVISIBLE);
            }
        });
    }

}