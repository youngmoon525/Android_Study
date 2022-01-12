package com.example.mystudyapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystudyapp.RecView.RecDTO;
import com.example.mystudyapp.RecView.RecyclerViewAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView rec;
    ArrayList<RecDTO> list;
    RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        rec = (RecyclerView) rootView.findViewById(R.id.RecyclerView);
        list = new ArrayList<RecDTO>();
        list.add(new RecDTO(R.drawable.build, "사교/인맥", "[FIKA]PREMIUM",
                                "서울특별시 강남구", "142명", 33));
        list.add(new RecDTO(R.drawable.mountain, "취미/여가", "등반하실 분 급구",
                "한라산", "14명", 3));
        list.add(new RecDTO(R.drawable.date, "연애/데이팅", "경기도 하남^^(심심하신 분)",
                "경기도 하남", "1명", 0));
        list.add(new RecDTO(R.drawable.hobby, "운동/스포츠", "축가하실 분 다 모여~!",
                "동네축구장", "5명", 4));
        list.add(new RecDTO(R.drawable.busking, "문화/공연", "3시 성남동 공연입니다.★",
                "경기도 성남시", "8명", 8));
        list.add(new RecDTO(R.drawable.poong, "인플루언서", "15일 팬미팅 16:00진행합니다!",
                "지스타", "35명", 432));
        list.add(new RecDTO(R.drawable.army, "팬클럽", "아미 15일 6시 정모입니다. ^^",
                "서울특별시 강남구", "354명", 1231));
        list.add(new RecDTO(R.drawable.lol, "게임/오락", "한판 뛰실 착한 정글러 구해요~",
                "비대면", "4명", 0));
        list.add(new RecDTO(R.drawable.food, "맛집/요리", "쥑이는 집~ 아무나 한끼같이 해요",
                "경기도 안산", "5명", 5));

        adapter = new RecyclerViewAdapter(getActivity(), list);

        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        rec.setAdapter(adapter);
        return rootView;
    }
}