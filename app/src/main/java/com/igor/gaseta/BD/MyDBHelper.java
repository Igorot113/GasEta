package com.igor.gaseta.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_COMBUSTIVEL = "combustiveis";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_GAS = "gasolina";
    public static final String COLUMN_ETA = "etanol";
    private static final String SQL_CREATE_COMBUSTIVEL_TABLE =
            "CREATE TABLE " + TABLE_COMBUSTIVEL + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_GAS + " TEXT NOT NULL," +
                    COLUMN_ETA + " TEXT NOT NULL UNIQUE);";
    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_COMBUSTIVEL_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMBUSTIVEL);
        onCreate(db);
    }
}
