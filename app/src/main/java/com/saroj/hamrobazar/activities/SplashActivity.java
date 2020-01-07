package com.saroj.hamrobazar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.saroj.hamrobazar.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("Term",MODE_PRIVATE);
                Boolean agree = sharedPreferences.getBoolean("agree",false);

                if(agree.equals(true) ){
                    Toast.makeText(SplashActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(SplashActivity.this, DashboardActivity.class);
                    startActivity(myIntent);
                }else{
                    Intent intent = new Intent(SplashActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2000);
    }
}
