package com.sbbi.obesityappv2.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sbbi.obesityappv2.helper.DBHelper;
import com.sbbi.obesityappv2.model.Finger;
import com.sbbi.obesityappv2.model.User;

/**
 * Created by bsilva on 3/2/17.
 */

public class ObesityDbDao {

    private Context context;
    private DBHelper helper;
    private final int FINGER_HEIGHT = 1;
    private final int FINGER_WIDTH = 2;
    private final int USER_ID = 3;
    private final int USER_NAME = 4;

    public ObesityDbDao(Context context){
        this.context = context;
        helper = new DBHelper(context);
    }

    public boolean isEmpty(){

        boolean isEmpty = true;
        SQLiteDatabase db = helper.getReadableDatabase();

        //String[] columns = {ObesityDb.Obesity._ID};
        String[] columns = {ObesityDb.Obesity.USER_ID, ObesityDb.Obesity.USER_NAME};
        Cursor cursor = db.query(ObesityDb.Obesity.TABLE_NAME, columns, null, null, null, null, null);

        if(cursor.moveToNext()){
            isEmpty = false;
        }
        cursor.close();
        db.close();
        return isEmpty;
    }

    public User getUser(){

        SQLiteDatabase db = helper.getReadableDatabase();
        User user = null;

        String[] columns = {ObesityDb.Obesity.USER_ID, ObesityDb.Obesity.USER_NAME};
        Cursor cursor = db.query(ObesityDb.Obesity.TABLE_NAME, columns, null, null, null, null, null);
        //Cursor cursor = db.query(ObesityDb.Obesity.TABLE_NAME, null, null, null, null, null, null);

        while(cursor.moveToNext()){

            int id = cursor.getInt(0);
            String name = cursor.getString(1);

            user = new User();
            user.setId(id);
            user.setName(name);
        }
        cursor.close();
        db.close();
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
        cursor.close();
        db.close();
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
        db.close();
    }

    public void addUser(User user){

        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ObesityDb.Obesity.USER_ID, user.getId());
        values.put(ObesityDb.Obesity.USER_NAME, user.getName());
        values.put(ObesityDb.Obesity.FINGER_HEIGHT, -1);
        values.put(ObesityDb.Obesity.FINGER_WIDTH, -1);

        long newRow = db.insert(ObesityDb.Obesity.TABLE_NAME, null, values);
        db.close();
    }

    public void delete() {

        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("DELETE FROM " + ObesityDb.Obesity.TABLE_NAME);
        db.close();
    }
}
