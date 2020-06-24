package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/6/24 13:27
 * @Purpose :
 */
public class GmDBHelp extends SQLiteOpenHelper {
    public static final String TABLE_NAME="cities";
    public static final Integer DEFAULT_VERSION = 1;
    public static final String DEFAULT_NAME="skmd.db";

    public GmDBHelp(@Nullable Context context) {
        super(context, DEFAULT_NAME, null, DEFAULT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String carInfom = "create table " + TABLE_NAME + " (" +
                "id integer ," +
                "pid integer," +
                "shortname text," +
                "c_name text," +
                "merger_name text," +
                "level text," +
                "c_pinyin text," +
                "code text," +
                "zip_code text," +
                "first text," +
                "lng text," +
                "lat text," +
                "hot text," +
                "c_code text," +
                "c_province text);";
        sqLiteDatabase.execSQL(carInfom);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
