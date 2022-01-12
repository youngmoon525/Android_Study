package com.example.mockupproject.navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.mockupproject.R;
import com.example.mockupproject.activity.MainActivity;

public class SpotNavigation extends Fragment {
    Context context;


    public SpotNavigation(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.spot_navigation, container, false);
        return  rootView;
    }
}