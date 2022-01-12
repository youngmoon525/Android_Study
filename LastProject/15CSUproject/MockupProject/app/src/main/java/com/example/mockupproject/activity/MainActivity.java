package com.example.mockupproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mockupproject.R;
import com.example.mockupproject.navigation.HomeNavigation;
import com.example.mockupproject.navigation.MagazineNavigation;
import com.example.mockupproject.navigation.MypageNavigation;
import com.example.mockupproject.navigation.SpotNavigation;
import com.example.mockupproject.navigation.VideoNavigation;
import com.example.mockupproject.transactivity.TransActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public BottomNavigationView bottom_nav;
    private long backKeyPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getPreferences(MainActivity.MODE_PRIVATE);

        if(preferences.getString("trans", null) == null) {
            Intent intent = new Intent(MainActivity.this, TransActivity.class);
            startActivity(intent);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("trans", "");
            editor.apply();
        }

        bottom_nav = findViewById(R.id.bottom_nav);

        changeFragment(new HomeNavigation(this));

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1){
                    changeFragment(new HomeNavigation(MainActivity.this));
                    return true;
                } else if(item.getItemId() == R.id.tab2){
                    changeFragment(new VideoNavigation(MainActivity.this));
                    return true;
                } else if(item.getItemId() == R.id.tab3){
                    changeFragment(new SpotNavigation(MainActivity.this));
                    return true;
                } else if(item.getItemId() == R.id.tab4){
                    changeFragment(new MagazineNavigation(MainActivity.this));
                    return true;
                } else if(item.getItemId() == R.id.tab5){
                    changeFragment(new MypageNavigation(MainActivity.this));
                    return true;
                }
                return false;
            }
        });

    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(MainActivity.this, "한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            SharedPreferences preferences = getPreferences(MainActivity.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("trans");
            editor.apply();

            finishAffinity();
        }
    }
}