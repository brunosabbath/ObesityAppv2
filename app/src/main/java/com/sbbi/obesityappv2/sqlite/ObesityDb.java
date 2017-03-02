package com.sbbi.obesityappv2.sqlite;

import android.provider.BaseColumns;

/**
 * Created by bsilva on 3/2/17.
 */

public class ObesityDb {

    private ObesityDb(){}

    public static class Obesity implements BaseColumns{
        public static final String TABLE_NAME = "obesity";
        public static final String FINGER_WIDTH = "userFingerWidth";
        public static final String FINGER_HEIGHT = "userFingerHeight";
        public static final String USER_ID = "userId";
        public static final String USER_NAME = "userName";
    }

}
