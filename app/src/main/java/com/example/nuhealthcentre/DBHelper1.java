package com.example.nuhealthcentre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper1 extends SQLiteOpenHelper {
    public DBHelper1(Context context) {
        super(context, "Userdata1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(catid TEXT primary key, cate TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetils");

    }

    public Boolean insertuserdata(String catid, String cate) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("catid", catid);
        contentValues.put("cate", cate);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String catid, String cate) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cate", cate);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where catid = ?", new String[]{catid});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "catid=?", new String[]{catid});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata(String catid) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where catid = ?", new String[]{catid});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "catid=?", new String[]{catid});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }

}
