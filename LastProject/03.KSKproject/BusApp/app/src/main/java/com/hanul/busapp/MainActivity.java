package com.hanul.busapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.hanul.busapp.etc.Etc_frag;
import com.hanul.busapp.favorite.Fav_frag;
import com.hanul.busapp.route.Route_frag;
import com.hanul.busapp.station.Station_frag;
import com.hanul.busapp.transfer.Trans_frag;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Menu menu;
    TabLayout tab_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_nav);
        menu = bottomNavigationView.getMenu();

        Fav_frag fav = new Fav_frag();
        getSupportFragmentManager().beginTransaction().replace(R.id.container , fav).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_fav){
                    Fav_frag fav = new Fav_frag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , fav).commit();
                    return true;
                }else if(item.getItemId() == R.id.menu_bus){
                    Station_frag bus = new Station_frag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,bus).commit();
                    return true;
                }else if(item.getItemId() == R.id.menu_route){
                   Route_frag route = new Route_frag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, route).commit();
                    return true;
                }else if(item.getItemId() == R.id.menu_trans){
                    Trans_frag trans = new Trans_frag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, trans).commit();
                    return true;
                }else if(item.getItemId() == R.id.menu_etc){
                    Etc_frag etc = new Etc_frag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, etc).commit();
                    return true;
                }
                return false;
            }
        });



    }

}