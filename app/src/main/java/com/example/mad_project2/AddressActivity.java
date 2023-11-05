package com.example.mad_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddressActivity extends AppCompatActivity {

    Button addNewAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        addNewAdd = findViewById(R.id.add_new_add);

        addNewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popup coming up
                showDialog();
            }
        });
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_new_address);

        TextView name,add1,add2,add3;
        EditText et_name,et_add1,et_add2,et_add3;
        Button add;

        name=findViewById(R.id.name_2);
        add1=findViewById(R.id.addr_2_line_1);
        add2=findViewById(R.id.addr_2_line_2);
        add3=findViewById(R.id.addr_2_line_3);

        et_name=findViewById(R.id.enter_name);
        et_add1=findViewById(R.id.enter_address);
        et_add2=findViewById(R.id.enter_city);
        et_add3=findViewById(R.id.enter_state);

        add=findViewById(R.id.btn_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sname = et_name.getText().toString();
                String Sadd1 = et_add1.getText().toString();
                String Sadd2 = et_add2.getText().toString();
                String Sadd3 = et_add3.getText().toString();

                name.setText(Sname);
                add1.setText(Sadd1);
                add2.setText(Sadd2);
                add3.setText(Sadd3);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}