package com.example.newlastproject.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.newlastproject.LoginActivity;
import com.example.newlastproject.R;

public class NotiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);
        //공유자원 <- LoginDTO가 null인지 체크 로그인 안되었으면
        //=> 로그인페이지로 이동
        //로그인이 되어있다면 화면을 정상적으로 보여주고.
        Intent intent = new Intent(NotiActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}