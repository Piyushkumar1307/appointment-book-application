package com.example.nuhealthcentre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(docid TEXT primary key, mobile TEXT, first TEXT, last TEXT, email TEXT, specialization TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetils");

    }

    public Boolean insertuserdata(String docid, String mobile, String first, String last, String email, String specialization) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("docid", docid);
        contentValues.put("mobile", mobile);
        contentValues.put("first", first);
        contentValues.put("last",last);
        contentValues.put("email", email);
        contentValues.put("specialization", specialization);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String docid, String mobile, String first, String last, String email, String specialization) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mobile", mobile);
        contentValues.put("first", first);
        contentValues.put("last",last);
        contentValues.put("email", email);
        contentValues.put("specialization", specialization);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where docid = ?", new String[]{docid});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "docid=?", new String[]{docid});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata(String docid) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where docid = ?", new String[]{docid});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "docid=?", new String[]{docid});
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

