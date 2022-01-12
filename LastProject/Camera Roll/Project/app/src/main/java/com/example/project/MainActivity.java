package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView = null;
    RecyclerViewAdapter mAdapter = null;
    ArrayList<RecyclerViewDTO> mList;

    BottomNavigationView bottomNavigationView;

    private Drawable mImageDrawable;
    private String mMainText;
    private String mSubText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mList = new ArrayList<>();
        mMainText = "yasuo";
        mSubText = "www.yasuo.com";

        for (int i = 0 ; i<30 ; i++){

            mList.add(new RecyclerViewDTO(mImageDrawable, mMainText + i+1, mSubText ) );
        }
        mAdapter = new RecyclerViewAdapter(mList , MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        mImageDrawable = ResourcesCompat.getDrawable(getResources(),R.drawable.btn_signin_twitter,null);




        mAdapter.notifyDataSetChanged();


    }





}
