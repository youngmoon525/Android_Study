package com.example.mozak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mozak.Fragment.AccountFragment;
import com.example.mozak.Fragment.HomeFragment;
import com.example.mozak.Fragment.ReelsFragment;
import com.example.mozak.Fragment.SearchFragment;
import com.example.mozak.Fragment.ShopFragment;
import com.example.mozak.recycler.RecyclerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment(MainActivity.this)).commit();


        btm_view = findViewById(R.id.btm_nav);
        btm_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment(MainActivity.this)).commit();
                }else  if(item.getItemId() == R.id.menu_search){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment(MainActivity.this)).commit();
                }else  if(item.getItemId() == R.id.menu_reels){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ReelsFragment(MainActivity.this)).commit();
                }else  if(item.getItemId() == R.id.menu_shop){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ShopFragment(MainActivity.this)).commit();
                }else if (item.getItemId() == R.id.menu_account){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new AccountFragment(MainActivity.this)).commit();
                }

                return true;
            }
        });




    }
}