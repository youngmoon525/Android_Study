package com.example.frip.Frag1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.frip.MainActivity;
import com.example.frip.R;

public class ChatActivity extends AppCompatActivity {


    ImageView btn_chat_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        btn_chat_back = findViewById(R.id.btn_chat_back);

        btn_chat_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }



        });



    }
}