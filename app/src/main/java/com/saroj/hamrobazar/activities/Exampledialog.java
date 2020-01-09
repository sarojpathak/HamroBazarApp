package com.saroj.hamrobazar.activities;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.saroj.hamrobazar.R;

public class Exampledialog extends AppCompatDialogFragment {

    EditText etEmail,etPassword;
    Button btnLogin,btnForget,btnSignUp;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.login_dialoge,null);
        builder.setView(view)
                .setTitle("Login")
                .setPositiveButton("Don't have account?Rregister Here", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getContext(),SignupActivity.class);
                        getContext().startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getContext(),DashboardActivity.class);
                        getContext().startActivity(intent);
                    }
                });
        etEmail=view.findViewById(R.id.etEmail);
        etPassword=view.findViewById(R.id.etPassword);
        btnForget=view.findViewById(R.id.btnForget);
        btnSignUp=view.findViewById(R.id.btnSignUp);
        btnLogin=view.findViewById(R.id.btnLogin);

        return builder.create();
    }
}
