package com.example.mad_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FridgeActivity extends AppCompatActivity {

    Button btadd1;
    TextView txt1, txt;
    Integer a1, res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        btadd1 = findViewById(R.id.add_btn_fridge);

        txt1 = findViewById(R.id.price_rate_f1);

        txt = findViewById(R.id.total_2);

        String str1=txt1.getText().toString();
        a1=Integer.parseInt(str1);


        btadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res+a1;
                txt.setText(res.toString());
            }
        });
    }
}