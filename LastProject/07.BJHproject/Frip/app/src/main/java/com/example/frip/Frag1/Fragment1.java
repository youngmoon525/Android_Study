package com.example.frip.Frag1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.frip.MainActivity;
import com.example.frip.Pager2.Pager2Adapter;
import com.example.frip.Pager2.Pager2DTO;
import com.example.frip.R;
import com.example.frip.Rec.RecAdapter;
import com.example.frip.Rec.RecDTO;

import java.util.ArrayList;


public class Fragment1 extends Fragment {
    RecyclerView recyclerView;
    ArrayList<RecDTO> list;
    ArrayList<Pager2DTO> list2;
    Context context;

    ViewPager2 pager2;



    public Fragment1(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_1, container, false);



        recyclerView = view.findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        
        list.add(new RecDTO(R.drawable.house,"혼펜"));
        list.add(new RecDTO(R.drawable.thunder,"할인"));
        list.add(new RecDTO(R.drawable.money,"재테크"));
        list.add(new RecDTO(R.drawable.strong,"다이어트"));
        list.add(new RecDTO(R.drawable.tiger,"신년운세"));
        list.add(new RecDTO(R.drawable.labtop,"제주워케이션"));
        list.add(new RecDTO(R.drawable.wine,"와인"));
        list.add(new RecDTO(R.drawable.ok,"당일예약"));
        list.add(new RecDTO(R.drawable.baking,"베이킹"));
        list.add(new RecDTO(R.drawable.mountain,"산행"));
        list.add(new RecDTO(R.drawable.tangerine,"제주"));
        list.add(new RecDTO(R.drawable.bus,"여행"));
        list.add(new RecDTO(R.drawable.camping,"프립캠핑"));
        list.add(new RecDTO(R.drawable.dance,"댄스"));
        list.add(new RecDTO(R.drawable.wave,"부산"));
        list.add(new RecDTO(R.drawable.delivery,"배송KIT"));
        list.add(new RecDTO(R.drawable.soup,"밀키트"));
        list.add(new RecDTO(R.drawable.lipstick,"뷰티"));
        list.add(new RecDTO(R.drawable.heart,"커플"));


        RecAdapter adapter = new RecAdapter(context,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        pager2 = view.findViewById(R.id.pager2);

        list2 = new ArrayList<>();

        list2.add(new Pager2DTO(R.drawable.pagerimg1," 1/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg2," 2/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg3," 3/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg4," 4/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg5," 5/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg6," 6/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg7," 7/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg8," 8/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg9," 9/ 10+"));
        list2.add(new Pager2DTO(R.drawable.pagerimg10,"10/ 10+"));

        Pager2Adapter pager2adapter = new Pager2Adapter(context,list2);

        pager2.setAdapter(pager2adapter);






        return view;
    }



}

