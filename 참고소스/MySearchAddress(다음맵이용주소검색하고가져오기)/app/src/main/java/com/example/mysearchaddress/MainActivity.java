package com.example.mysearchaddress;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private final int SEARCH_ADDR_CODE = 1001;
EditText edt_addr , edt_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_addr = findViewById(R.id.edt_addr);
        edt_post = findViewById(R.id.edt_post);
        Intent intent = new Intent(MainActivity.this,SearchAddrActivity.class);
        startActivityForResult(intent,SEARCH_ADDR_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SEARCH_ADDR_CODE){
            String addr = data.getExtras().getString("addr");
            String post = data.getExtras().getString("post");
            if(data != null){
                edt_addr.setText(addr);
                edt_post.setText(post);


            }
        }
    }
}