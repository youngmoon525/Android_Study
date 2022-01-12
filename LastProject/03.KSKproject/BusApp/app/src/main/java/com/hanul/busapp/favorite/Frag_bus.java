package com.hanul.busapp.favorite;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanul.busapp.R;

public class Frag_bus extends Fragment {
    RecyclerView bus_rcview;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_frag_bus, container, false);
        bus_rcview = rootView.findViewById(R.id.bus_rcview);


        return rootView;
    }


}