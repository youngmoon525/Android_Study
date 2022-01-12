package com.example.frip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.frip.Frag1.ChatActivity;
import com.example.frip.Frag1.Fragment1;
import com.example.frip.Frag1.LocalFragment;
import com.example.frip.Frag2.Fragment2;
import com.example.frip.Login.LoginActivity2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_nav;
    private LinearLayout btn_local;
    private LinearLayout btn_chat;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_nav = findViewById(R.id.bottom_nav);

        Fragment1 frag1 =new Fragment1(this);
        Fragment2 frag2 =new Fragment2(this);
        Fragment3 frag3 =new Fragment3();
        Fragment4 frag4 =new Fragment4();
        Fragment5 frag5 =new Fragment5();

        btn_chat =findViewById(R.id.btn_chat);

        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        btn_local = findViewById(R.id.btn_local);

        btn_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = MainActivity.this;
                getSupportFragmentManager().beginTransaction().replace(R.id.container , new LocalFragment(context)).commit();

            }
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.container , frag1).commit();





        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.tab1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , frag1).commit();
                    return true;

                }else if (item.getItemId() == R.id.tab2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , frag2).commit();
                    return true;

                }else if (item.getItemId() == R.id.tab3){
                    Toast.makeText(MainActivity.this, "3번째 프레그먼트 (미구현) ", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , frag3).commit();
                    return true;

                }else if (item.getItemId() == R.id.tab4){
                    Toast.makeText(MainActivity.this, "4번째 프레그먼트 (미구현)", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , frag4).commit();
                    return true;

                }else if (item.getItemId() == R.id.tab5){
                    Toast.makeText(MainActivity.this, "5번째 프레그먼트 (미구현)", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , frag5).commit();
                    return true;
                }





                    return false;
            }
        });
    }
}