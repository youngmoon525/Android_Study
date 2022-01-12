package com.example.chaminhwan_kakaostory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.chaminhwan_kakaostory.fgm.common.ChangeFragment;
import com.example.chaminhwan_kakaostory.fgm.fgm01_home;
import com.example.chaminhwan_kakaostory.fgm.fgm02_search;
import com.example.chaminhwan_kakaostory.fgm.fgm03_center;
import com.example.chaminhwan_kakaostory.fgm.fgm04_notice;
import com.example.chaminhwan_kakaostory.fgm.fgm05_mypage;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    ChangeFragment changeFragment;
    ActionBar actionBar; //전역변수로 Actionbar를 선언만 해둠.
    BottomNavigationView bottom_nav;
    int fml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeFragment = new ChangeFragment();
        fml = R.id.container;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        actionBar = getSupportActionBar();//os가 return  // 이거 뭐임?;;
        //actionBar.setTitle("머야 ");

        changeFragment(new fgm01_home(), fml);
        bottom_nav = findViewById(R.id.bottom_nav);

        FragmentManager manager = getSupportFragmentManager();

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.tab1) {
                    changeFragment(new fgm01_home(), fml);
                    return true;
                } else if (item.getItemId() == R.id.tab2) {
                    changeFragment(new fgm02_search(), fml);
                    return true;
                } else if (item.getItemId() == R.id.tab3) {
                    changeFragment(new fgm03_center(), fml);
                    return true;
                } else if (item.getItemId() == R.id.tab4) {
                    changeFragment(new fgm04_notice(MainActivity.this, manager), fml);
                    return true;
                } else if (item.getItemId() == R.id.tab5) {
                    changeFragment(new fgm05_mypage(MainActivity.this, manager), fml);
                    return true;
                }


                return false;
            }
        });

    }

    public void changeFragment(Fragment fragment, String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void changeFragment(Fragment fragment, int fml) {
        getSupportFragmentManager().beginTransaction().replace(fml, fragment).commit();
    }



}


