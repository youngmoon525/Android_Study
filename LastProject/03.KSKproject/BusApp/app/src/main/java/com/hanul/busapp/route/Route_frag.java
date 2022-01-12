package com.hanul.busapp.route;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanul.busapp.R;
import com.hanul.busapp.station.StationAdapter;

public class Route_frag extends Fragment {
    Context context;
    RecyclerView rec_route;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_route_frag, container, false);
        rec_route = rootView.findViewById(R.id.rec_route);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        RouteAdapter adapter = new RouteAdapter(getActivity());
        rec_route.setLayoutManager(layoutManager);
        rec_route.setAdapter(adapter);

        return rootView;
    }
}