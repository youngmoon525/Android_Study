package com.example.newlastproject.transactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.newlastproject.R;

public class TransActivity extends AppCompatActivity {
// TransActivity라는것은 액티비티 위에 액티비티가 떴을때.
//투명색으로 배경이 있어서 뒤에 앱이 실제로 돌아가는것처럼
//보이는 디자인을 만드는것 ( 주로 Guide , Splash 등등 에서 사용 )
// theme <- 테마를 이용해서 테마에 미리 스타일을 지정해놓고 그다음 Manifest에서 테마를 연결사용.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}