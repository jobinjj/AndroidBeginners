package com.allianzetechnologies.checkconnectionbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ConnectivityBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isInternetAvailable(context)){
            Toast.makeText(context, "Has connection", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "No connection", Toast.LENGTH_SHORT).show();
    }
    public boolean isInternetAvailable(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
