package com.saroj.hamrobazar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.saroj.hamrobazar.R;

import org.w3c.dom.Text;

public class PostingRuleActivity extends AppCompatActivity {
    private Text txtPost;
    private Button btnPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting_rule);

        btnPost = findViewById(R.id.btnPost);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostingRuleActivity.super.onBackPressed();
            }
        });
    }
}
