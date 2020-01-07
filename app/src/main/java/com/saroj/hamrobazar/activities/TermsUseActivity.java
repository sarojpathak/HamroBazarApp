package com.saroj.hamrobazar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.saroj.hamrobazar.R;

import org.w3c.dom.Text;

public class TermsUseActivity extends AppCompatActivity {
    private Text txtTerm;
    private Button btnTerm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_use);

        btnTerm = findViewById(R.id.btnTerm);

        btnTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TermsUseActivity.super.onBackPressed();
            }
        });
    }
}
