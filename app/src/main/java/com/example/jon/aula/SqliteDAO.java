package com.example.jon.aula;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by jon on 17/05/17.
 */

public class SqliteDAO extends SQLiteOpenHelper {

    private static final String DB_NAME = "ponto";
    private static final int DB_VERSION = 1;
    public SqliteDAO(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PontoDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
