package com.example.mydatabaseproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDB.db";
    public static final String TABLE_NAME = "Student";
    public static final String COLUMN_ID = "StudentID";
    public static final String COLUMN_NAME = "StudentName";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +COLUMN_ID+ "INTEGER PRIMARYKEY," + COLUMN_NAME + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String loadHandler(){
        String result = "";
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_1);
        }
        cursor.close();
        db.close();
        return result;
    }

    public void addHandler(Student student){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, student.getStudentID());
        contentValues.put(COLUMN_NAME, student.getStudentName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, contentValues);
        db.close();

    }

}
