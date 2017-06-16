package com.sbbi.obesityappv2.helper;

import android.content.Context;

import com.sbbi.obesityappv2.model.User;
import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

/**
 * Created by bsilva on 6/16/17.
 */

public class GetUserIdHelper {

    public static int getUserId(Context context) {
        ObesityDbDao dao = new ObesityDbDao(context);
        User user = dao.getUser();
        return user.getId();
    }

}
