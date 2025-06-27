package com.igor.gaseta.CombustivelDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.igor.gaseta.BD.MyDBHelper;
public class CombustivelDAO {
    private SQLiteDatabase database;
    private MyDBHelper dbHelper;
    public CombustivelDAO(Context context) {
        dbHelper = new MyDBHelper(context);
    }
    public void open() {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }
    public long addCombustivel(String name, String email) {
        ContentValues values = new ContentValues();
        values.put(MyDBHelper.COLUMN_GAS, name);
        values.put(MyDBHelper.COLUMN_ETA, email);
        return database.insert(MyDBHelper.TABLE_COMBUSTIVEL, null, values);
    }
    public void deleteAllCombustiveis() {
        database.execSQL("DELETE FROM "+ MyDBHelper.TABLE_COMBUSTIVEL);
    }
}
