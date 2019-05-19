package com.example.chatapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 6000;

    TextView textview;
    TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);



        textview = (TextView) findViewById(R.id.my_text);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "Fonts/AliandoRocky.ttf");
        textview.setTypeface(myCustomFont);

        textview1 = (TextView) findViewById(R.id.my_text_1);
        Typeface myCustomFont1 = Typeface.createFromAsset(getAssets(), "Fonts/ralewaythin.ttf");
        textview1.setTypeface(myCustomFont1);

        RelativeLayout relativeLayout = findViewById(R.id.back);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(0);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}
