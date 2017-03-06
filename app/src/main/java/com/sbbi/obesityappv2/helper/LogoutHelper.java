package com.sbbi.obesityappv2.helper;

import android.content.Context;

import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

/**
 * Created by bsilva on 3/6/17.
 */

public class LogoutHelper {

    public static void logout(Context context){
        ObesityDbDao dao = new ObesityDbDao(context);
        dao.delete();
    }

}
