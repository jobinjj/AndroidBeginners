package com.allianzetechnologies.wifilistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBTReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.bluetooth.BluetoothDevice.ACTION_ACL_CONNECTED")){
            Log.d("bluetooth","Bluetooth connect");
        }
    }
}