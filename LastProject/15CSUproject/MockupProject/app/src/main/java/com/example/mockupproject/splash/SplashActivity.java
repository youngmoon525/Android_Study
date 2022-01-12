package com.example.mockupproject.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mockupproject.activity.MainActivity;
import com.example.mockupproject.R;

public class SplashActivity extends AppCompatActivity {
    ImageView logo_bg;
    Animation expansion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo_bg = findViewById(R.id.logo_bg);
        expansion = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.expansion);

        logo_bg.startAnimation(expansion);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}