package com.example.newlastproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.newlastproject.customer.CusFragment;
import com.example.newlastproject.noti.NotiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new NotiFragment(this)).commit();
        btm_view = findViewById(R.id.btm_nav);
        btm_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_noti){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container , new NotiFragment(MainActivity.this)).commit();
                }else if(item.getItemId() == R.id.menu_cus){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container , new CusFragment(MainActivity.this)).commit();
                }


                return true;
            }
        });
    }// oncreate()






}