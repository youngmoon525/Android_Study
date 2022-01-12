package com.example.chaminhwan_kakaostory.fgm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.chaminhwan_kakaostory.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class fgm05_mypage extends Fragment {
    BottomNavigationView mypage_top_nav, mypage_middle_nav;
    Context context;
    FragmentManager manager;
    ImageView img_profile;
    FrameLayout frameLayout;

    public fgm05_mypage(Context context, FragmentManager manager) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        changeFragment(new fgm05_mypage_01_square());
        View v = inflater.inflate(R.layout.fragment_fgm05_mypage, container, false);
        // Inflate the layout for this fragment
        img_profile = v.findViewById(R.id.mypage_img_profile);
        img_profile.bringToFront();
/*        frameLayout = v.findViewById(R.id.mypage_proflelayout);
        frameLayout.bringToFront();*/


        mypage_top_nav = v.findViewById(R.id.mypage_top_nav);
        mypage_top_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mypage_top_burger) {
                    manager.beginTransaction().replace(R.id.container, new fgm05_mypage_00_option()).commit();
                    return true;
                }
                return false;
            }
        });

        mypage_middle_nav = v.findViewById(R.id.mypage_middle_nav);
        mypage_middle_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.mypage_middle_tab_square) {
                    changeFragment(new fgm05_mypage_01_square());
                    return true;
                }
                if (item.getItemId() == R.id.mypage_middle_tab_list) {
                    changeFragment(new fgm05_mypage_02_list());
                    return true;
                }
                if (item.getItemId() == R.id.mypage_middle_tab_friend) {
                    changeFragment(new fgm05_mypage_01_square());
                    return true;
                }
                if (item.getItemId() == R.id.mypage_middle_tab_info) {
                    changeFragment(new fgm05_mypage_01_square());
                    return true;
                }
                return false;
            }
        });

        return v;

    }


    public void changeFragment(Fragment fragment) {
        manager.beginTransaction().replace(R.id.mypage_container, fragment).commit();
    }

}