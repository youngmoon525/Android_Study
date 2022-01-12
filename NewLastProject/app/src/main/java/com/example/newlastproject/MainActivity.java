package com.example.newlastproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newlastproject.customer.CusFragment;
import com.example.newlastproject.noti.NotiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_view;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////=============================================
        View decorView = getWindow().getDecorView();
        int uiOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOption);
        ///===============풀스크린 모드로 시계 영역 가리기

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this , drawer , toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );//햄버거 버튼 만들기 ( 버튼을 눌러서 반전시키는 효과를 만듬 )
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView nav_view = findViewById(R.id.nav_view);

        View nav_headerview = nav_view.getHeaderView(0);
        ImageView nav_img = nav_headerview.findViewById(R.id.nav_image);
        TextView nav_textv = nav_headerview.findViewById(R.id.nav_text1);

        Glide.with(MainActivity.this).load("http://192.168.0.60:80/mid/resources/uploadand/2022/01/12/8ef4251e-9bfb-45e2-a408-0586981ca00f_My20220112 0110441453925151859203156.jpg").into(nav_img);
       //nav_textv.setText("");




        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new NotiFragment(this)).commit();
        btm_view = findViewById(R.id.btm_nav);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


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