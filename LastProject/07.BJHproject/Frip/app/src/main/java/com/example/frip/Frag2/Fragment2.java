package com.example.frip.Frag2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.frip.R;

import java.util.ArrayList;


public class Fragment2 extends Fragment {
    RecyclerView recyclerView;
    ArrayList<KateDTO> list;
    Context context;


    public Fragment2(Context context) {
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add(new KateDTO(R.drawable.pagerimg1,R.drawable.pagerimg2,"아웃도어","피트니스"));

        for (int i =1; i<30;i+=2){
            list.add(new KateDTO(R.drawable.pagerimg8,R.drawable.pagerimg9,"액티비티"+i,"액티비티"+(i+1)));
            list.add(new KateDTO(R.drawable.pagerimg5,R.drawable.pagerimg7,"액티비티"+(i+2),"액티비티"+(i+3)));
            list.add(new KateDTO(R.drawable.pagerimg3,R.drawable.pagerimg4,"액티비티"+(i+4),"액티비티"+(i+5)));



        }

        KateAdapter adapter = new KateAdapter(context,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);






        return view;
    }
}