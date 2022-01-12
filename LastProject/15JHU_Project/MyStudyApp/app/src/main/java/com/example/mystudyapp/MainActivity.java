package com.example.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment fragment_event = new EventFragment();
    Fragment fragment_home = new HomeFragment();
    Fragment fragment_chat = new ChatFragment();
    Fragment fragment_profile = new ProfileFragment();

    ImageView search;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });


        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(
                    @NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.page_home:
                        viewPager.setCurrentItem(0);
                    return true;
                    case R.id.page_event:
                        viewPager.setCurrentItem(1);
                    return true;
                    case R.id.page_chat:
                        viewPager.setCurrentItem(2);
                    return true;
                    case R.id.page_profile:
                        viewPager.setCurrentItem(3);
                        return true;
                }
                    return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigation.getMenu().findItem(R.id.page_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigation.getMenu().findItem(R.id.page_event).setChecked(true);
                        break;
                    case 2:
                        bottomNavigation.getMenu().findItem(R.id.page_chat).setChecked(true);
                        break;
                    case 3:
                        bottomNavigation.getMenu().findItem(R.id.page_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

}