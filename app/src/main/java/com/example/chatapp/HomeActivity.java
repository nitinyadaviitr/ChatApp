package com.example.chatapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
