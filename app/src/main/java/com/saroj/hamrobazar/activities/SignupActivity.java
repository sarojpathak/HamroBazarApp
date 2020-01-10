package com.saroj.hamrobazar.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.saroj.hamrobazar.R;
import com.saroj.hamrobazar.api.UsersAPI;
import com.saroj.hamrobazar.model.User;
import com.saroj.hamrobazar.serverresponse.ImageResponse;
import com.saroj.hamrobazar.serverresponse.SignUpResponse;
import com.saroj.hamrobazar.strictmode.StrictModeClass;
import com.saroj.hamrobazar.url.Url;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private CircleImageView imgProfile;
    private EditText etEmail, etFullname, etPwd, etPassword, etPhone,etMobilephone, etStreet,etArea;
    private Spinner etCity;
    private Button btnRegister;
    private CheckBox chkHidephone,chkNewsletter,chkAgree;
    String imagePath;
    private String imageName = "";

    public static final String city[] = {
             "Kathmandu" ,
             "New Delhi",
             "London",
            "Ottawa"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,city
        );

        imgProfile = findViewById(R.id.imgProfile);
        etFullname = findViewById(R.id.etFullname);
        etEmail = findViewById(R.id.etEmail);
        etPwd = findViewById(R.id.etPwd);
        etPassword = findViewById(R.id.etRePassword);
        etPhone = findViewById(R.id.etPhone);
        etMobilephone = findViewById(R.id.etMobilephone);
        etStreet = findViewById(R.id.etStreet);
        etArea = findViewById(R.id.etArea);
        etCity = findViewById(R.id.etCity);
        chkNewsletter = findViewById(R.id.chkNewsletter);
        chkHidephone = findViewById(R.id.chkHidephone);
        chkAgree = findViewById(R.id.chkAgree);
        btnRegister = findViewById(R.id.btnRegister);
        etCity.setAdapter(arrayAdapter);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPassword.getText().toString().equals(etPwd.getText().toString())) {
//                    Toast.makeText(SignupActivity.this, "heres", Toast.LENGTH_SHORT).show();
//                    return;
                    if(validate()) {
                        saveImageOnly();
                        signUp();
                    }
                } else {
                    Toast.makeText(SignupActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    etPwd.requestFocus();
                    return;
                }

            }
        });
    }
    private boolean validate() {
        boolean status=true;
        if(etEmail.getText().toString().length()==0){
            etEmail.setError("Enter your email address");
            status=false;
        }
        if(etFullname.getText().toString().length()==0){
            etFullname.setError("Enter your full name");
            status=false;
        }

        if (etPwd.getText().toString().length() < 6) {
            etPwd.setError("Minimum 6 character");
            status=false;
        }
        if(etPhone.getText().toString().length()==0){
            etPhone.setError("Enter your phone number");
            status=false;
        }
        if(etMobilephone.getText().toString().length()==0){
            etMobilephone.setError("Enter your mobile number");
            status=false;
        }
        if(etStreet.getText().toString().length()==0){
            etStreet.setError("Enter your street address");
            status=false;
        }
        if(etArea.getText().toString().length()==0){
            etArea.setError("Enter your Area address");
            status=false;
        }
        chkNewsletter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkNewsletter.setTag(isChecked ? true : false);
            }
        });
        chkHidephone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkHidephone.setTag(isChecked ? true : false);
            }
        });
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkAgree.setTag(isChecked ? true : false);
            }
        });
        return status;
    }

    private void BrowseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please select an image ", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imgProfile.setImageURI(uri);
        imagePath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),
                uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void saveImageOnly() {
        File file = new File(imagePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",
                file.getName(), requestBody);

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<ImageResponse> responseBodyCall = usersAPI.uploadImage(body);

        StrictModeClass.StrictMode();
        //Synchronous methid
        try {
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            imageName = imageResponseResponse.body().getFilename();
            Toast.makeText(this, "Image inserted" + imageName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void signUp() {

        String fullName = etFullname.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPwd.getText().toString();
        Integer phone = Integer.parseInt(etPhone.getText().toString());
        Integer mobilePhone =Integer.parseInt( etMobilephone.getText().toString());
        String street = etStreet.getText().toString();
        String area = etArea.getText().toString();
        String city = etCity.getSelectedItem().toString();
        boolean newsletter = Boolean.parseBoolean(String.valueOf(chkNewsletter.isChecked()?true:false));
        boolean hidePhone = Boolean.parseBoolean(String.valueOf(chkHidephone.isChecked()?true:false));
        boolean agree = Boolean.parseBoolean(String.valueOf(chkAgree.isChecked()?true:false));


        User users = new User(fullName, email, password,phone,mobilePhone,street,area,city,newsletter,hidePhone,agree,imageName);

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> signUpCall = usersAPI.registerUser(users);
        CheckPermission();
        signUpCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(SignupActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(SignupActivity.this, "Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void CheckPermission()
    {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED ||ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED )
        {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }
    }
}
