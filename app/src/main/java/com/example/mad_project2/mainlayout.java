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
//                displayWalletFragment();
                replaceFragemt(new WalletFragment());
            } else {
                replaceFragemt(new HomeFragment());
            }

            return true;
        });


    }

//    private void displayWalletFragment() {
//        WalletFragment walletFragment = WalletFragment.newInstance(9999); // Replace 9999 with the appropriate data
//        replaceFragemt(walletFragment);
//    }
    private void replaceFragemt(Fragment fragment){
        Bundle bundle = new Bundle();
        int membershipId = 100; // Replace with the actual int value
        bundle.putInt("membershipId", membershipId);

        // Set the arguments for the fragment
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout , fragment);
        fragmentTransaction.commit();
    }
}