package com.example.mozak.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mozak.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerview);

        ArrayList<RecyclerDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new RecyclerDTO(i+"00" , "test"+(i+1)));

        }

        RecyclerAdapter adapter = new RecyclerAdapter(RecyclerActivity.this, list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                RecyclerActivity.this, RecyclerView.VERTICAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}