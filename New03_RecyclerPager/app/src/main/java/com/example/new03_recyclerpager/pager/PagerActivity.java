package com.example.new03_recyclerpager.pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.new03_recyclerpager.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class PagerActivity extends AppCompatActivity {
 //0.pager2를 액티비티에 추가 ( 기존 API 형식으로 gradle 넣어야만 사용가능 => 기본제공 )
//1. xml아이템준비 ==> Fragment를 준비 ( 각각의 화면을 다르게 컨트롤할수있게 )
//2. xml <-> java ==> Fragment를 사용할수있게 생성
    //3.어댑터만들기 ( RecyclerAdapter랑 매우 유사함 )
    ViewPager2 pager2;
    WormDotsIndicator indicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        pager2 = findViewById(R.id.pager2);
        indicator = findViewById(R.id.dots_indicator);
        Pager2Adapter adapter = new Pager2Adapter(PagerActivity.this);
        pager2.setAdapter(adapter);
        indicator.setViewPager2(pager2);
    }
}