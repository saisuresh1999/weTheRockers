package com.example.jayand_zuch569.srmhack;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class DashBoard extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private MainDashboard mainDashBoard;
    private Settings settings;
    public FrameLayout mMainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        settings=new Settings();
        mainDashBoard = new MainDashboard();
        mMainFrame = (FrameLayout) findViewById(R.id.mainFrame);
        mMainNav=(BottomNavigationView) findViewById(R.id.bottom_nav);

        mMainNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                 @Override
                 public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                     switch (Item.getItemId()) {
                         case R.id.nav_home: {
                             setFragment(mainDashBoard);
                             mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                             return true;
                         }
                         case R.id.nav_settings: {
                             mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                             setFragment(settings);
                             return true;
                     }
                     default:
                         return false;
                     }
                 }
             }
        );
    }
    private void setFragment(Fragment anyFragment) {
        @SuppressLint("CommitTransaction") FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.mainFrame,anyFragment);

    }
}
