package com.example.mozak.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mozak.MainActivity;
import com.example.mozak.Pager2.Pager2Adapter;
import com.example.mozak.R;
import com.example.mozak.recycler.RecyclerActivity;
import com.example.mozak.recycler.RecyclerAdapter;
import com.example.mozak.recycler.RecyclerDTO;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    ViewPager2 pager2;
    DotsIndicator indicator;

    public HomeFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerview);


        ArrayList<RecyclerDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new RecyclerDTO("user"+(i+1), "user"+(i+1)+"이 작성한 글입니다"));


        }

        RecyclerAdapter adapter = new RecyclerAdapter(context, list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                context, RecyclerView.VERTICAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}