package com.example.chaminhwan_kakaostory.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chaminhwan_kakaostory.MainActivity;
import com.example.chaminhwan_kakaostory.R;

public class LoginActivity extends AppCompatActivity {
    Button btn_login_kakao, btn_login;
    TextView tv_signon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login_kakao = findViewById(R.id.login_btn_kakaologin);
        btn_login_kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login = findViewById(R.id.login_btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Login_SigninActivity.class);
                startActivity(intent);
            }
        });

        tv_signon = findViewById(R.id.login_tv_signon);
        tv_signon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Login_SignonActivity.class);
                startActivity(intent);
            }
        });


    }
}