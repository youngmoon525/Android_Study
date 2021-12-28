package com.example.new03_recyclerpager.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.new03_recyclerpager.R;

public class RecyclerTestActivity extends AppCompatActivity {
//1.액티비티에서 보여줄 Recycler를 xml에 추가하기.(R.layout.ac...) ctrl + click
//2.java <-> xml 연결 ( find를 통해서 연결 )
//3.보여줄 item을 만듬 ( xml <- item의 위젯 갯수보다는 DTO의 필드갯수가 더많거나 같아야함)
//4.Adapter만들기 .<-
//5. LayoutManager <- 가로 방향인지 , 세로 방향인지 아이템을 붙일 방향을 지정하기 위한객체
    RecyclerView rec1 , rec2 ;//setContentView<-소스 다음줄부터 xml에 있는 내용을 찾을수있음.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_test);
        rec1 = findViewById(R.id.rec1);
        rec2 = findViewById(R.id.rec2);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(
            RecyclerTestActivity.this , RecyclerView.HORIZONTAL , false
        );
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(
                RecyclerTestActivity.this , RecyclerView.VERTICAL , false
        );
        RecTestAdapter adapter1 = new RecTestAdapter(RecyclerTestActivity.this);
        RecTestAdapter adapter2 = new RecTestAdapter(RecyclerTestActivity.this);
        rec1.setLayoutManager(layoutManager1);
        rec2.setLayoutManager(layoutManager2);
        rec1.setAdapter(adapter1);
        rec2.setAdapter(adapter2);
    }
}