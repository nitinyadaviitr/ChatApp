package com.example.chatapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView textview;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);

        textview = (TextView) findViewById(R.id.my_text_1);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "Fonts/ralewaythin.ttf");
        textview.setTypeface(myCustomFont);

        if(haveNetwork()){
            //MainFunction
            button = (Button) findViewById(R.id.my_text_1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openChat();
                }
            });
        }
        else if(!haveNetwork()){
            button = (Button) findViewById(R.id.my_text_1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText( HomeActivity.this, "Please connect to Internet", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void openChat(){
        Intent intent = new Intent(this, chattab.class);
        startActivity(intent);
    }

    private boolean haveNetwork()
    {
        boolean have_wifi = false;
        boolean have_data = false;

        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for(NetworkInfo info:networkInfos)
        {
            if(info.getTypeName().equalsIgnoreCase( "WIFI"))
            if(info.isConnected())
                have_wifi = true;
            if(info.getTypeName().equalsIgnoreCase( "MOBILE"))
            if(info.isConnected())
                have_data = true;
        }
        return have_data||have_wifi;
    }
}
