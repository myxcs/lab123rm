package com.example.lab123rm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Todo_DB" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //tao bang
         String sql = "CREATE TABLE IF NOT EXISTS TODO (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, data TEXT, type TEXT, status int)";
         db.execSQL(sql);
        //nhap du lieu mau
         String data = "INSERT INTO TODO (title, content, data, type, status) VALUES ('học java', 'học java cơ bản', '2019-12-12', 'học java', 0)";
         db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   //xoa bang neu old != new
        if (oldVersion != newVersion) {
            String sql = ("DROP TABLE IF EXISTS TODO");
            db.execSQL(sql);
            onCreate(db);
        }
    }
}
