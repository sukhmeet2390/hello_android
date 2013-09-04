package com.sukhmeet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 04/09/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_ANDROID = "ANDROID";
    public static final String COL_ID = "_ID";
    public static final String COL_COMMENT = "COMMENT";
    private static final String DATABASE_NAME = "SUKHMEET";
    private static final int DATABASE_VERSION = 1;

    private static final String DB_CREATE = "create table " + TABLE_ANDROID + "(" +
            COL_ID + " integer primary key autoincrement, " + COL_COMMENT+ " text not null);";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        System.out.println("Updating the db");
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from "+ oldVersion + " to "+ newVersion);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_ANDROID);
        onCreate(sqLiteDatabase);
    }
}
