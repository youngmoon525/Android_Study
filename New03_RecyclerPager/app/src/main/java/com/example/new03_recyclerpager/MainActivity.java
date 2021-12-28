package com.example.new03_recyclerpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.new03_recyclerpager.pager.PagerActivity;
import com.example.new03_recyclerpager.recycler.RecyclerActivity;
import com.example.new03_recyclerpager.recycler.RecyclerTestActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1 , btn2 , btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "리사클러뷰는 어댑터의 커스터마이징을 강제한다." +
                                "기본 형태의 어댑터를 제공안함.", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // RecyclerActivity로 이동=>???
                // 액티비티간 이동 Intent <- 객체를 이용해서 함.
                //생성시 지금위치 , 이동할 위치의 클래스
                Intent intent = new Intent(MainActivity.this , RecyclerTestActivity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // RecyclerActivity로 이동=>???
                // 액티비티간 이동 Intent <- 객체를 이용해서 함.
                //생성시 지금위치 , 이동할 위치의 클래스
                Intent intent = new Intent(MainActivity.this , PagerActivity.class);
                startActivity(intent);
            }
        });
    }
}