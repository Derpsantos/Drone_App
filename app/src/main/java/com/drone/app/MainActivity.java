package com.drone.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.drone.app.fragments.ControllerFragment;
import com.drone.app.fragments.DroneConditionFragment;
import com.drone.app.fragments.DroneSettingFragment;
import com.drone.app.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();

    }


    private void initBottomNavigation() {
        BottomNavigationView navView = findViewById(R.id.bottom_nav);
        navView.setOnNavigationItemSelectedListener(this);
        LoadFragment(new ControllerFragment());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        if(item.getItemId()==R.id.nav_controller) {
            LoadFragment(new ControllerFragment());
        }else if(item.getItemId()==R.id.nav_condition){
            LoadFragment(new DroneConditionFragment());
        }else if(item.getItemId()==R.id.nav_setting) {
            LoadFragment(new DroneSettingFragment());
        }else if(item.getItemId()==R.id.nav_profile){
            LoadFragment(new ProfileFragment());
        }
        return true;
    }
    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}