package com.example.jon.aula;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jon on 18/05/17.
 */

public class PontoDAO {

    private static final String TABLE =  "ponto";
    private static final String ID = "id";
    private static final String DIA = "dia";
    private static final String HORA = "hora";
    private static final String ACAO = "acao";

    public static final String CREATE_TABLE =  "Create table if not exists "+ TABLE +" ( "+
            ID + " int, "+ DIA + " long, "+ HORA +" long, "+ ACAO+" int);";

    private SqliteDAO sqliteDAO;
    private Context context;

    public PontoDAO(Context context) {
        this.context = context;
        sqliteDAO = new SqliteDAO(context);
    }

    public long insert(Ponto ponto){
        SQLiteDatabase db = sqliteDAO.getWritableDatabase();
        long id = db.insert(TABLE, null, getContentValues(ponto));
        return id;
    }

    private ContentValues getContentValues(Ponto ponto){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DIA, ponto.getDia().getTime());
        contentValues.put(HORA, ponto.getHora().getTime());
        contentValues.put(ACAO,ponto.getAcao());
        return contentValues;
    }

}
