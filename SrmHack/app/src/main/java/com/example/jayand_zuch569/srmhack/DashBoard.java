package com.example.jayand_zuch569.srmhack;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class DashBoard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bottomNavigationView = findViewById(R.id.navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here
        final Fragment fragment1 = new MainDashboard();
        final Fragment fragment2 = new Settings();

        // handle navigation selection
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.frame, fragment1).commit();
                                return true;
                            case R.id.nav_settings:
                                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                                fragmentTransaction1.replace(R.id.frame, fragment2).commit();
                                return true;
                            }
                        return true;
                    }
                });
    }
}
