package com.allianzetechnologies.checkconnectionbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ConnectivityBroadcastReceiver connectivityBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectivityBroadcastReceiver = new ConnectivityBroadcastReceiver();
        registerReceiver(connectivityBroadcastReceiver, new IntentFilter(ConnectivityManager.EXTRA_NO_CONNECTIVITY));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(connectivityBroadcastReceiver);
    }
}
