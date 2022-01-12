package com.example.mockupproject.navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mockupproject.R;
import com.example.mockupproject.activity.MainActivity;
import com.example.mockupproject.adapter.Video_Adapter_Pager1;
import com.example.mockupproject.adapter.Video_Adapter_Pager2;
import com.google.android.material.tabs.TabLayout;

public class VideoNavigation extends Fragment {
    Context context;
    TabLayout tab_layout;
    ViewPager2 pager2;
    public VideoNavigation(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.video_navigation, container, false);
        tab_layout = rootView.findViewById(R.id.video_tab);
        pager2 = rootView.findViewById(R.id.video_pager);

        tab_layout.addTab(tab_layout.newTab().setText("추천"));
        tab_layout.addTab(tab_layout.newTab().setText("멍TV"));

        Video_Adapter_Pager1 adapter_pager1 = new Video_Adapter_Pager1(context);
        pager2.setAdapter(adapter_pager1);

        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if(position == 0){
                    Video_Adapter_Pager1 adapter_pager1 = new Video_Adapter_Pager1(context);
                    pager2.setAdapter(adapter_pager1);
                } else {
                    Video_Adapter_Pager2 adapter_pager2 = new Video_Adapter_Pager2(context);
                    pager2.setAdapter(adapter_pager2);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return  rootView;
    }
}