package com.hanul.busapp.favorite;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hanul.busapp.R;
import com.hanul.busapp.bus.BusVO;
import com.hanul.busapp.station.StationAdapter;

import java.util.ArrayList;

public class Fav_frag extends Fragment {
    ViewPager2 bus_pager;
    TabLayout tabLayout;
    ArrayList<BusVO> list = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_frag_fav, container, false);
        bus_pager = rootView.findViewById(R.id.bus_pager);
        tabLayout = rootView.findViewById(R.id.tab_layout);

        list.add(new BusVO("　즐겨찾기가 없습니다"));
        list.add(new BusVO("　양산초교입구(집 → 학원)","　양산호수공원방향(4058)"));
        list.add(new BusVO("　첨단95(상행)","　첨단95(첨단종점 ~ 첨단종점)"));

        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("정류장(노선정보)");
        tabList.add("정류장");
        tabList.add("노선");

        bus_pager.setAdapter(new TestAdapter(getActivity(),list));
        bus_pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        new TabLayoutMediator(tabLayout, bus_pager, (tab, position) -> tab.setText(tabList.get(position))).attach();

        return rootView;
    }

}