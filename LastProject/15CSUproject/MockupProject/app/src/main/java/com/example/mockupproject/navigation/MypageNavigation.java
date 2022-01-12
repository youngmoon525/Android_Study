package com.example.mockupproject.navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mockupproject.DTO.OnClickDTO;
import com.example.mockupproject.R;
import com.example.mockupproject.activity.MainActivity;
import com.example.mockupproject.adapter.MyPage_Adapter_Grid;

import java.util.ArrayList;

public class MypageNavigation extends Fragment {
    Context context;
    GridView gridView;
    ArrayList<OnClickDTO> oclist = new ArrayList<>();
    ArrayList<Integer> glist = new ArrayList<>();
    HomeNavigation homeNavigation = new HomeNavigation(context);

    public MypageNavigation(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mypage_navigation, container, false);

        gridView = rootView.findViewById(R.id.mypage_grid);

        for (int i = 0 ; i< 15 ; i++){
            if(i%2 ==0){
                glist.add(R.drawable.image3);
            } else {
                glist.add(R.drawable.image4);
            }
        }

        MyPage_Adapter_Grid adapter = new MyPage_Adapter_Grid(context, glist);
        gridView.setAdapter(adapter);

        oclist.add(new OnClickDTO(R.id.mypage_add, "mypage_add 이동"));
        oclist.add(new OnClickDTO(R.id.mypage_setting, "mypage_setting 이동"));
        oclist.add(new OnClickDTO(R.id.mypage_invite, "mypage_invite 이동"));

        homeNavigation.buttonAction(oclist, rootView);

        return  rootView;
    }
}