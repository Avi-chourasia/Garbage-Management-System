package com.example.garbagemanagementsystem.ui.fragment.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.garbagemanagementsystem.MainActivity;
import com.example.garbagemanagementsystem.R;
import com.example.garbagemanagementsystem.ui.fragment.authentication.AuthenticationActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splashscreen = new Intent(SplashScreenActivity.this , AuthenticationActivity.class);
                startActivity(splashscreen);
            }
        },3000);
    }
}