package com.example.myexpandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //ExpandableListView는 부모(Group) 안에 자식(Child)
    //ListView안에 ListView가 붙는 방식입니다.

    //1.디자인에 위젯을 추가
ExpandableListView expdListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.데이터에 사용할 ArrayList를 만듬.
        ArrayList<ExpdDTO> list= new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            list.add(new ExpdDTO("title" + i , "content"+ i , "2022-02-0" + i , "답변답변" + i));
        }

        expdListView = findViewById(R.id.expdListView);
        //3.어댑터 만들기.
        ExpandableAdapter adapter = new ExpandableAdapter((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE) , list);
        expdListView.setAdapter(adapter);


    }
}