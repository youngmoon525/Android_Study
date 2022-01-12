package com.example.mystudyapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystudyapp.RecView.RecEventAdapter;
import com.example.mystudyapp.RecView.RecEventDTO;

import java.util.ArrayList;


public class EventFragment extends Fragment {
    RecyclerView rec;
    RecEventAdapter adapter;
    ArrayList<RecEventDTO> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_event, container, false);

        rec = (RecyclerView) rootView.findViewById(R.id.RecEvent);

        list = new ArrayList<RecEventDTO>();
        list.add(new RecEventDTO(R.drawable.taro, "취미/여가", "신년운세 무료로 보기!", "비대면",
                "10명", "PM", "03:00"));
        adapter = new RecEventAdapter(getActivity(), list);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        rec.setAdapter(adapter);

        return rootView;


    }
}