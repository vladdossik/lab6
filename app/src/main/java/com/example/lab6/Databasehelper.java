package com.example.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Databasehelper extends SQLiteOpenHelper {
    private static final String COL2 = "name";
    private static final String COL3="price";
     private static final String COL4="amount";
    public static String DB_name = "range";
    public Databasehelper(Context context) {

        super(context, DB_name, null, 7);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + DB_name + " (ID INTEGER PRIMARY KEY , " +
                COL2 + " TEXT," +
                COL3 + " INTEGER," +
                COL4 + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_name);
        onCreate(db);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DB_name;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    public void Add(String name, int price, int amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3,price);
        contentValues.put(COL4,amount);
        db.insert(DB_name, null, contentValues);
    }

    public void delete(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_name, COL2 +" = " +name, null);
    }
    public void replace(String name, int value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        value--;
        contentValues.put(COL4, value);
        db.update(DB_name, contentValues, "name = " + name, null);

    }
}

