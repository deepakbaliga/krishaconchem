package com.deepakbaliga.krishnaconchem;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class SplashScreen extends AppCompatActivity {

    private ImageView splashImage;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        splashImage = (ImageView) findViewById(R.id.splash_image);
        logo = (ImageView) findViewById(R.id.logo);

        Glide.with(this).load(R.drawable.splash).into(splashImage);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        },1500);



    }
}
