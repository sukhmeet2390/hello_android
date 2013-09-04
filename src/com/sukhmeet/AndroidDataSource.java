package com.sukhmeet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 04/09/13
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
// THIS SHOULD BE OUR DATA ACCESS OBJECT

public class AndroidDataSource {
    private SQLiteDatabase  database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COL_ID, MySQLiteHelper.COL_COMMENT };

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }

    public AndroidDataSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }
    public void open() throws SQLiteException{
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public Comment insertComment(String comment){
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COL_COMMENT, comment);
        long insertId = database.insert(MySQLiteHelper.TABLE_ANDROID, null, values);
        //query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ANDROID, allColumns,
                MySQLiteHelper.COL_ID+ "="+insertId, null, null, null, null);
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteComment(Comment comment){
        long id = comment.getId();
        System.out.println("Delete comment with id "+ id);
        database.delete(MySQLiteHelper.TABLE_ANDROID, MySQLiteHelper.COL_ID +" = " + id, null);
    }

    public List<Comment> getAllComments(){
        List<Comment> commentList = new ArrayList<Comment>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ANDROID, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Comment comment = cursorToComment(cursor);
            commentList.add(comment);
            cursor.moveToNext();
        }
        cursor.close();
        return commentList;
    }
}
