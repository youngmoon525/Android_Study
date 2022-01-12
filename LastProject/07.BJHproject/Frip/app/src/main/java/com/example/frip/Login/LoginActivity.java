package com.example.frip.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.frip.MainActivity;
import com.example.frip.R;

public class LoginActivity extends AppCompatActivity  {
    Button btn_kakao, btn_login;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(LoginActivity.this, "아이디 : a , 비밀번호 : a, \n로그인스킵 : 카카오톡 로그인버튼 (카카오구현안됨)", Toast.LENGTH_LONG).show();

        btn_kakao = findViewById(R.id.btn_kakao);

        btn_kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LoginActivity2.class);
                startActivity(intent);
            }
        });




    }
}