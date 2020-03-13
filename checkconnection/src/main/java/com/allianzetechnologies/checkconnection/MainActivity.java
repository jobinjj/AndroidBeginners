package com.allianzetechnologies.checkconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isInternetAvailable()){
            Toast.makeText(this, "Has connection", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(this, "No connection", Toast.LENGTH_SHORT).show();
    }

    public boolean isInternetAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
