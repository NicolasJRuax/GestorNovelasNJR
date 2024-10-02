package com.myproyect.gestornovelasnjr.gestor_novelas.Sync;



import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

    public static boolean isConnectedToWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null
                && networkInfo.isConnected()
                && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }
}
