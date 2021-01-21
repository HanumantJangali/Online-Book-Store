package com.example.onlinebookstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASENAME = "Online Book Store.db";


    //User Table and its column for registration and login
    public static final String TABLE_USER = "User_Data";

    public static  final String ID = "id";
    public static  final String USERNAME = "username";
    public static  final String EMAIL = "email";
    public static  final String PASSWORD = "password";


    //creating table data for user table
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + ID + " INTEGER PRIMARY KEY," + USERNAME
            + " TEXT," + EMAIL + " TEXT," + PASSWORD
            + " TEXT" + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

//adding user
    public boolean registerUser(String username, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME,username);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);
        long result = db.insert(TABLE_USER, null,contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {ID};
        String selection = EMAIL + "=?" + " and " + PASSWORD + "=?";
        String[] selectionargs = {email, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionargs, null, null, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();

        if (count > 0)
            return true;
        else
            return false;
    }

}
