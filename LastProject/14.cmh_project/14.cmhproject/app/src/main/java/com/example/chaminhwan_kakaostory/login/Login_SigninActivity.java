package com.example.chaminhwan_kakaostory.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chaminhwan_kakaostory.R;

public class Login_SigninActivity extends AppCompatActivity {
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signin);

        btn_back = findViewById(R.id.signin_btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_SigninActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}