package com.example.mad_project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainlayout extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlayout);
        replaceFragemt(new HomeFragment());

        navigationView = findViewById(R.id.bottom_nav);

        navigationView.setOnItemSelectedListener(item -> {



            if (item.getItemId()==R.id.nav_home){
                replaceFragemt(new HomeFragment());
            } else if (item.getItemId()==R.id.nav_orders) {
                replaceFragemt(new OrderFragment());
            } else if (item.getItemId()==R.id.nav_wallet) {
                replaceFragemt(new WalletFragment());
            } else {
                replaceFragemt(new HomeFragment());
            }

            return true;
        });


    }
    private void replaceFragemt(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout , fragment);
        fragmentTransaction.commit();
    }
}