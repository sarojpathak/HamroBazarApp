package com.saroj.hamrobazar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.saroj.hamrobazar.R;

import org.w3c.dom.Text;

public class SafetyTripsActivity extends AppCompatActivity {
    private Text txtSafety;
    private Button btnSafety;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_trips);

        btnSafety = findViewById(R.id.btnSafety);

        btnSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SafetyTripsActivity.super.onBackPressed();
            }
        });
    }
}
