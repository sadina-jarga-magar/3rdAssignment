package com.example.esoftwarica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);



        BottomNavigationView bottomnav = findViewById (R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener (navListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener () {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId ()){
                        case R.id.navhome:
                            selectedFragment = new HomeFragment ();
                            break;
                        case R.id.navaddstudent:
                            selectedFragment = new AddStudentFragment ();
                            break;
                        case R.id.navabout:
                            selectedFragment = new AboutUsFragment ();
                            break;
                    }
                    getSupportFragmentManager ().beginTransaction ().replace (R.id.fragment_container,selectedFragment).commit ();
                    return true;
                }
            };
}
