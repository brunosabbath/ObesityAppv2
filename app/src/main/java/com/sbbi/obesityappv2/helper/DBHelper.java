package com.sbbi.obesityappv2.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sbbi.obesityappv2.sqlite.ObesityDb;

/**
 * Created by bsilva on 3/2/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "obesity.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ObesityDb.Obesity.TABLE_NAME + " (" +
                    ObesityDb.Obesity._ID + " INTEGER PRIMARY KEY," +
                    ObesityDb.Obesity.FINGER_HEIGHT + " REAL," +
                    ObesityDb.Obesity.FINGER_WIDTH + " REAL," +
                    ObesityDb.Obesity.USER_ID + " INTEGER," +
                    ObesityDb.Obesity.USER_NAME+ " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ObesityDb.Obesity.TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("DATABASE", "onCreate");
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("DATABASE", "onUpgrade");
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("DATABASE", "onDowngrade");
        onUpgrade(db, oldVersion, newVersion);
    }
}
