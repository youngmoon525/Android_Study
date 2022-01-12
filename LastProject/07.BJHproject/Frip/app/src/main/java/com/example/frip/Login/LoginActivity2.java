package com.example.frip.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.frip.MainActivity;
import com.example.frip.R;

public class LoginActivity2 extends AppCompatActivity {

    Button btn_login2;
    EditText edt_id, edt_pw;
    String id, pw;
    ImageView btn_login_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Toast.makeText(LoginActivity2.this, "아이디 : a , 비밀번호 : a, \n로그인스킵 : 카카오톡 로그인버튼 (카카오구현안됨)", Toast.LENGTH_LONG).show();


        btn_login2 = findViewById(R.id.btn_login2);
        btn_login_back = findViewById(R.id.btn_login_back);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);

        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = edt_id.getText()+"";
                pw = edt_pw.getText()+"";

                if(id.equals("a") && pw.equals("a")){
                    Toast.makeText(LoginActivity2.this, "로그인이 되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity2.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity2.this, "잘못된 아이디 혹은 비밀번호 입력", Toast.LENGTH_SHORT).show();
                }



            }
        });



        btn_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity2.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}