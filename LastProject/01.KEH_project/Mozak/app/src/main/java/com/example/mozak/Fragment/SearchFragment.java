package com.example.mozak.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.mozak.search.SearchDTO;
import com.example.mozak.R;
import com.example.mozak.search.SearchAdapter;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    GridView gridView;
    Context context;
    SearchView cus_schview;

    public SearchFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        ArrayList<SearchDTO> list = new ArrayList<>();
        SearchAdapter adapter = new SearchAdapter(getContext(), list);
        gridView = rootView.findViewById(R.id.search_gridv);
       /* AtaskConn ataskConn = new AtaskConn("list.vw");
        try {
            InputStream is = ataskConn.execute().get();
            Gson gson = new Gson();
            list = gson.fromJson(new InputStreamReader(is), new TypeToken<List<SearchDTO>>(){}.getType());
            adapter.addItem(list);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        gridView.setAdapter(adapter);

        cus_schview = rootView.findViewById(R.id.search_schview);

        cus_schview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //검색 버튼(엔터를 눌렀을 때 엔터키를 누른 순간까지 입력된 글자들을 가져옴)
                Toast.makeText(context, query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //글자가 바뀔 때마다 그 순간에 입력된 글자까지 전부 가져옴.(이벤트 발생 빈번)
                Toast.makeText(context, newText, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return rootView;
    }
}