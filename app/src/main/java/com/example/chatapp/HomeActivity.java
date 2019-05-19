package com.example.chatapp;

import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);

        textview1 = (TextView) findViewById(R.id.my_text_1);
        Typeface myCustomFont1 = Typeface.createFromAsset(getAssets(), "Fonts/ralewaythin.ttf");
        textview1.setTypeface(myCustomFont1);

        if(haveNetwork()){
            //MainFunction
        }
        else if(!haveNetwork()){
            Toast.makeText( HomeActivity.this, "Please connect to Internet", Toast.LENGTH_LONG).show();
        }
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
