package com.example.mockupproject.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mockupproject.DTO.OnClickDTO;
import com.example.mockupproject.R;
import com.example.mockupproject.activity.HomeSearchActivity;
import com.example.mockupproject.activity.MainActivity;
import com.example.mockupproject.adapter.Home_Adapter_Rec1;
import com.example.mockupproject.adapter.Home_Adapter_Rec2;
import com.example.mockupproject.adapter.Home_Adapter_Rec3;
import com.example.mockupproject.adapter.Home_Adapter_Rec4;
import com.example.mockupproject.adapter.Home_Adapter_Rec5;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeNavigation extends Fragment {
    RecyclerView rec1, rec2, rec3, rec4, rec5;
    Context context;
    LinearLayoutManager manager;
    SwipeRefreshLayout swipe;
    ArrayList<OnClickDTO> oclist = new ArrayList<>();
    MainActivity mainActivity = new MainActivity();

    public HomeNavigation(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_navigation, container, false);
        rec1 = rootView.findViewById(R.id.home_rec1);
        rec2 = rootView.findViewById(R.id.home_rec2);
        rec3 = rootView.findViewById(R.id.home_rec3);
        rec4 = rootView.findViewById(R.id.home_rec4);
        rec5 = rootView.findViewById(R.id.home_rec5);
        swipe = rootView.findViewById(R.id.home_swipe);

        oclist.add(new OnClickDTO(R.id.home_search, "home_search 이동"));
        oclist.add(new OnClickDTO(R.id.home_linear1, "home_linear1 이동"));
        oclist.add(new OnClickDTO(R.id.home_linear2, "home_linear2 이동"));
        oclist.add(new OnClickDTO(R.id.home_linear3, "home_linear3 이동"));
        oclist.add(new OnClickDTO(R.id.home_linear4, "home_linear4 이동"));
        oclist.add(new OnClickDTO(R.id.home_linear5, "home_linear5 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon1, "home_icon1 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon2, "home_icon2 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon3, "home_icon3 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon4, "home_icon4 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon5, "home_icon5 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon6, "home_icon6 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon5, "home_icon5 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon7, "home_icon7 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon8, "home_icon8 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon9, "home_icon9 이동"));
        oclist.add(new OnClickDTO(R.id.home_icon10, "home_icon10 이동"));
        oclist.add(new OnClickDTO(R.id.home_btn1, "home_btn1 이동"));

        setRec1();
        setRec2();
        setRec3();
        setRec4();
        setRec5();

        buttonAction(oclist, rootView);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setRec1();
                setRec2();
                setRec3();
                setRec4();
                setRec5();
                swipe.setRefreshing(false);
            }
        });

        return  rootView;
    }
    public void setRec1(){
        manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        rec1.setLayoutManager(manager);
        Home_Adapter_Rec1 adapter_rec1 = new Home_Adapter_Rec1(context);
        rec1.setAdapter(adapter_rec1);
    }
    public void setRec2(){
        manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        rec2.setLayoutManager(manager);
        Home_Adapter_Rec2 adapter_rec2 = new Home_Adapter_Rec2(context);
        rec2.setAdapter(adapter_rec2);
    }
    public void setRec3(){
        manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        rec3.setLayoutManager(manager);
        Home_Adapter_Rec3 adapter_rec3 = new Home_Adapter_Rec3(context);
        rec3.setAdapter(adapter_rec3);
    }
    public void setRec4(){
        manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        rec4.setLayoutManager(manager);
        Home_Adapter_Rec4 adapter_rec4 = new Home_Adapter_Rec4(context);
        rec4.setAdapter(adapter_rec4);
    }
    public void setRec5(){
        manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        rec5.setLayoutManager(manager);
        Home_Adapter_Rec5 adapter_rec5 = new Home_Adapter_Rec5(context);
        rec5.setAdapter(adapter_rec5);
    }

    public void buttonAction(ArrayList<OnClickDTO> oclist, View rootView){
        for (int i = 0; i < oclist.size(); i++) {
            if(oclist.get(i).getClickId() == R.id.home_search){
                rootView.findViewById(oclist.get(i).getClickId()).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent  = new Intent(context, HomeSearchActivity.class);
                        startActivity(intent);
                        mainActivity = (MainActivity) getActivity();
                        mainActivity.overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_left_exit);
                    }
                });
            } else if(oclist.get(i).getClickId() == R.id.home_btn1){
                rootView.findViewById(oclist.get(i).getClickId()).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainActivity = (MainActivity) getActivity();
                        mainActivity.changeFragment(new SpotNavigation(context));
                    }
                });
            } else {
            rootView.findViewById(oclist.get(i).getClickId()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "이동", Toast.LENGTH_SHORT).show();
                }
            });
            }
        }
    }

    public void dataSelect(String query){

    }
}