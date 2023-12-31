package com.hamidul.forloop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetCheck extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (isConnected(context)){
            Toast.makeText(context, "Internet Connected", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isConnected(Context context){
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE );
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo!=null && networkInfo.isConnected());

        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

}
