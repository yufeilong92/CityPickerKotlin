package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import java.lang.Exception

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/6/24 13:31
 * @Purpose :
 */
object GMhELP {
    @Volatile
    private var _singleton: GMhELP? = null
    var mContext: Context? = null
    var mSqLiteDatabase: SQLiteDatabase? = null
    fun GMhELP(context: Context): GMhELP? {
        mContext = context
        mSqLiteDatabase = createtable();
        return this
    }

    fun get_Instance(context: Context): GMhELP? {
        if (_singleton == null) {
            synchronized(GMhELP::class.java) {
                if (_singleton == null) {
                    _singleton = GMhELP(context)
                }
            }
        }
        return _singleton
    }

    fun createtable(): SQLiteDatabase {
        val databaseContext = DatabaseContext(mContext)
        var userHelp = GmDBHelp(databaseContext)
        return userHelp!!.writableDatabase
    }

    fun addExaSql(com: String) {
        mSqLiteDatabase!!.beginTransaction()
        try {
            Log.e("==","$com")
            mSqLiteDatabase!!.execSQL(com)
            mSqLiteDatabase!!.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        }finally {
            mSqLiteDatabase!!.endTransaction()
        }

    }
    fun delete(){
        mSqLiteDatabase!!.delete(GmDBHelp.TABLE_NAME,null,null)
    }

}