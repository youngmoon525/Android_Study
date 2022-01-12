package com.example.chaminhwan_kakaostory.fgm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.chaminhwan_kakaostory.MainActivity;
import com.example.chaminhwan_kakaostory.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class fgm04_notice extends Fragment {
    ActionBar actionBar;
    BottomNavigationView notice_top_nav;
    Context context;
    FragmentManager manager;

    public fgm04_notice(Context context, FragmentManager manager) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fgm04_notice, container, false);


        changeFragment(new fgm04_notice_01_alarm());

        notice_top_nav = v.findViewById(R.id.notice_top_nav);
        notice_top_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.notice_top_tab1) {
                    changeFragment(new fgm04_notice_01_alarm());
                    return true;
                } else if (item.getItemId() == R.id.notice_top_tab2) {
                    changeFragment(new fgm04_notice_02_msg());
                    return true;
                }

                return false;

            }
        });
        return v;
    }

    public void changeFragment(Fragment fragment, String msg) {
        Toast.makeText(context, msg + "123123", Toast.LENGTH_SHORT).show();

        manager.beginTransaction().replace(R.id.fgm_04_frame, fragment).commit();
    }

    public void changeFragment(Fragment fragment) {
        manager.beginTransaction().replace(R.id.fgm_04_frame, fragment).commit();
    }
}
