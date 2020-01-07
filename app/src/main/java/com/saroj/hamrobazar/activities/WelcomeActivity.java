package com.saroj.hamrobazar.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.saroj.hamrobazar.R;

public class WelcomeActivity extends Activity {
    private CheckBox checkBox1, checkBox2, checkBox3;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        checkBox1 = findViewById(R.id.checkBox2);
        checkBox2 = findViewById(R.id.checkBox4);
        checkBox3 = findViewById(R.id.checkBox);
        button = findViewById(R.id.button);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox1.setTag(isChecked ? "y" : "n");
                Intent intent = new Intent(WelcomeActivity.this, TermsUseActivity.class);
                startActivity(intent);
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox2.setTag(isChecked ? "y" : "n");
                Intent intent = new Intent(WelcomeActivity.this, SafetyTripsActivity.class);
                startActivity(intent);
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox3.setTag(isChecked ? "y" : "n");
                Intent intent = new Intent(WelcomeActivity.this, PostingRuleActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()){
                    StoreUserAccount();
                    Intent intent = new Intent(WelcomeActivity.this,SplashActivity.class);
                    startActivity(intent);
                } else{
                    alertDialog();

                }

            }

        });


    }
    private void StoreUserAccount(){
        SharedPreferences sharedPreferences =getSharedPreferences("Term", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean("agree", true);
        editor.commit();
    }
    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("You have not read Terms of Use. Please click about button to view it");
        dialog.setTitle("Terms Of Use");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}
