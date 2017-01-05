package com.sbbi.obesityappv2.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by bsilva on 1/5/17.
 */

public class ConnectionHelper {

    public static boolean isInternetAvailable(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if(activeNetwork != null)
            return true;
        else
            return false;

    }

}
