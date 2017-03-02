package com.sbbi.obesityappv2.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sbbi.obesityappv2.helper.DBHelper;
import com.sbbi.obesityappv2.model.Finger;
import com.sbbi.obesityappv2.model.User;

/**
 * Created by bsilva on 3/2/17.
 */

public class ObesityDbDao {

    private Context context;
    private DBHelper helper;
    private final int FINGER_HEIGHT = 2;
    private final int FINGER_WIDTH = 3;
    private final int USER_ID = 4;
    private final int USER_NAME = 5;

    public ObesityDbDao(Context context){
        this.context = context;
        helper = new DBHelper(context);
    }

    public boolean isEmpty(){

        boolean isEmpty = true;
        SQLiteDatabase db = helper.getWritableDatabase();

        String[] columns = {ObesityDb.Obesity._ID};
        Cursor cursor = db.query(ObesityDb.Obesity.TABLE_NAME, columns, null, null, null, null, null);

        if(cursor.moveToNext()){
            isEmpty = false;
        }

        return isEmpty;
    }

    public User getUser(){

        SQLiteDatabase db = helper.getWritableDatabase();
        User user = new User();

        String[] columns = {ObesityDb.Obesity.USER_ID, ObesityDb.Obesity.USER_NAME};
        Cursor cursor = db.query(ObesityDb.Obesity.TABLE_NAME, columns, null, null, null, null, null);

        if(cursor.moveToNext()){
            user.setId(cursor.getInt(USER_ID));
            user.setName(cursor.getString(USER_NAME));
        }

        return user;
    }

    public Finger getFinger(){

        SQLiteDatabase db = helper.getWritableDatabase();
        Finger finger = new Finger();

        String[] columns = {ObesityDb.Obesity.USER_ID, ObesityDb.Obesity.USER_NAME};
        Cursor cursor = db.query(ObesityDb.Obesity.TABLE_NAME, columns, null, null, null, null, null);

        if(cursor.moveToNext()){
            finger.setHeight(cursor.getDouble(USER_ID));
            finger.setWidth(cursor.getDouble(USER_NAME));
        }

        return finger;
    }

    public void addFinger(double fingerHeight, double fingerWidth){

        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        User user = getUser();

        values.put(ObesityDb.Obesity.FINGER_HEIGHT, fingerHeight);
        values.put(ObesityDb.Obesity.FINGER_WIDTH, fingerWidth);

        String selection = ObesityDb.Obesity.USER_ID + " = ?";
        String[] selectionArgs = {user.getId() + ""};

        db.update(ObesityDb.Obesity.TABLE_NAME, values, selection, selectionArgs);

    }

}
