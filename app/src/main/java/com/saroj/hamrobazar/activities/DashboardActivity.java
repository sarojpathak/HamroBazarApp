package com.saroj.hamrobazar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.saroj.hamrobazar.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity   {

   private Button btnSignUp;
    ImageView icon;
    Dialog myDialog;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    ViewFlipper vflipper;
    private RecyclerView recyclerView,recyclerViewSecond;

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.img:

        }
        return true;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        icon=findViewById(R.id.icon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
            }
        });


        myDialog= new Dialog(this);


        final Toolbar  toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        btnSignUp =  toolbar.findViewById(R.id.btnSignUp);


//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                toolbar.dismissPopupMenus();
////                Intent intent = new Intent(DashboardActivity.this, SignupActivity.class);
////                startActivity(intent);
//
//            }
//        });

//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DashboardActivity.this, SignupActivity.class);
//                startActivity(intent);
//            }
//        });




//
//        recyclerView=findViewById(R.id.recyclerView);
//
//        List<TreandingAds> treandingAdsList=new ArrayList<>();
//        treandingAdsList.add(new TreandingAds("Samsung Phone","40000",R.drawable.bike,"Brand New"));
//
//        TrendingAdsAdapter trendingAdsAdapter=new TrendingAdsAdapter(this,treandingAdsList);
//        recyclerView.setAdapter(trendingAdsAdapter);
//        recyclerView.setLayoutManager(
//                (new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)));
//
//        recyclerViewSecond=findViewById(R.id.recyclerViewSecond);
//
//        List<ListedAds> listedAdsList=new ArrayList<>();
//        listedAdsList.add(new ListedAds("Samsung Phone","40000",R.drawable.bike,"Brand New"));
//
//        ListedAdsAdapter listedAdsAdapter=new ListedAdsAdapter(this,listedAdsList);
//        recyclerViewSecond.setAdapter(listedAdsAdapter);
//        recyclerViewSecond.setLayoutManager(
//                (new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)));
//
//
//        int images[]={R.drawable.yamaha,R.drawable.car,R.drawable.bike,R.drawable.house,R.drawable.furnitures,R.drawable.music};
//
//        vflipper=findViewById(R.id.vflipper);
//
//
//
//        for (int image:images)
//        {
//            flipperimages(image);
//        }
    }

    private void ShowPopup(View v) {

        myDialog.setContentView(R.layout.activity_login);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void flipperimages (int image)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        vflipper.addView(imageView);
        vflipper.setFlipInterval(4000);
        vflipper.setAutoStart(true);

        //animation
        vflipper.setInAnimation(this,android.R.anim.slide_in_left);
        vflipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }
}