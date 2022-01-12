package com.hanul.busapp.station;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanul.busapp.R;

public class Station_frag extends Fragment {
    Context context;
    RecyclerView rec_station;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_station_frag, container, false);
        rec_station = rootView.findViewById(R.id.rec_station);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        StationAdapter adapter = new StationAdapter(getActivity());
        rec_station.setLayoutManager(layoutManager);
        rec_station.setAdapter(adapter);

        return rootView;
    }

}